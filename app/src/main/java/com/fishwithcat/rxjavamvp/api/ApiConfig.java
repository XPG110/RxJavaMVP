package com.fishwithcat.rxjavamvp.api;

import android.util.Log;

import com.fishwithcat.rxjavamvp.Constant;
import com.fishwithcat.rxjavamvp.MyApplication;
import com.fishwithcat.rxjavamvp.utils.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/12/19.
 */

public class ApiConfig {

    public static String TAG=ApiConfig.class.getSimpleName();

    private Retrofit mRetrofit;

    private OkHttpClient mClient;

    private static int TIME_OUT=1500;

    public static boolean ISTEST=true;

    private ApiConfig(){
        init();
    }

    private static ApiConfig instance;

    public static ApiConfig getInstance(){
        if(instance==null){
            synchronized (ApiConfig.class){
                if(instance==null){
                    instance=new ApiConfig();
                }
            }
        }
        return instance;
    }

    public void init(){

        mClient=new OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .cache(new Cache(MyApplication.getContext().getCacheDir(),1024*1024))
                .build();
    }

    public Retrofit getRetrofit(){
        mRetrofit=new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(mClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }

    public Retrofit getRetrofit(String host){
        mRetrofit=new Retrofit.Builder()
                .baseUrl(Constant.TEST_URL)
                .client(mClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }

    public Interceptor getInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetWorkUtils.isNetworkAvailable(MyApplication.getContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                    Log.i(TAG, "no network");
                }

                Response response = chain.proceed(request);

                if (NetWorkUtils.isNetworkAvailable(MyApplication.getContext())) {
                    int maxAge = 0 * 60; // 有网络时 设置缓存超时时间0个小时
                    Log.i(TAG, "has network maxAge="+maxAge);
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    Log.i(TAG, "network error");
                    int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
                    Log.i(TAG, "has maxStale="+maxStale);
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                    Log.i(TAG, "response build maxStale="+maxStale);
                }
                return response;
            }
        };
    }
}
