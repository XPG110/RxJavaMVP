package com.fishwithcat.rxjavamvp.api;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/7.
 */

public class BaseApi<T> {

    public BaseApi(){
        initData();
    }

    protected void initData(){

    }

    /**
     * 获取网络数据
     * @param obs
     * @param listener
     */
    protected void fetchData(Observable<T> obs, final SpliceListener listener){
        obs.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Action1<T>() {
            @Override
            public void call(T t) {
                listener.onNext();
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                listener.onError();
            }
        }, new Action0() {
            @Override
            public void call() {
                listener.onCancel();
            }
        });
    }

    public interface SpliceListener{
        void onNext();
        void onError();
        void onCancel();
    }

}
