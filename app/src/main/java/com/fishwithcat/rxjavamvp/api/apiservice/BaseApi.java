package com.fishwithcat.rxjavamvp.api.apiservice;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/12/19.
 */

public class BaseApi<T> {

    public BaseApi(){
        init();
    }

    private void init() {

    }

//    public BaseApi(){
//        initData();
//    }
//
//    protected void initData(){
//
//    }
//
//    public void request(Observable<T> obs, final Splice<T> splice){
//        obs.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
//                .subscribe(new Action1<T>() {
//                    @Override
//                    public void call(T t) {
//                        splice.onNext(t);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        splice.onError();
//                    }
//                }, new Action0() {
//                    @Override
//                    public void call() {
//                        splice.onCancel();
//                    }
//                });
//    }
//
//    public interface Splice<T>{
//        void onNext(T t);
//        void onError();
//        void onCancel();
//    }

}
