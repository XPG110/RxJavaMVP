package com.fishwithcat.rxjavamvp.api;

import com.fishwithcat.rxjavamvp.Constant;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/12/7.
 */

public class ApiConfig {

    private static Retrofit mRetrofit;

    private static OkHttpClient client;

    private ApiConfig(){
        init();
    }

    public static ApiConfig getInstance(){
        return SingletonHolder.apiConfig;
    }

    private static class SingletonHolder{
        public static ApiConfig apiConfig=new ApiConfig();
    }

    private void init(){
        client=new OkHttpClient.Builder()
                .addInterceptor(getInterceptor()).build();
    }

    private Retrofit getRetrofit(){
        mRetrofit=new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return mRetrofit;
    }

    private Retrofit getRetrofit(String host){
        mRetrofit=new Retrofit.Builder().baseUrl(Constant.TEST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return mRetrofit;
    }

    private Interceptor getInterceptor(){
        Interceptor interceptor = null;
        return interceptor;
    }
}
