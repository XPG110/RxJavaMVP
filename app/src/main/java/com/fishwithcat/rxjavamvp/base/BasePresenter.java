package com.fishwithcat.rxjavamvp.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/12/18.
 */

public class BasePresenter<T> implements LoadDataView{

    public Reference<T> viewRef;

    public void attachView(T view){
        viewRef=new WeakReference<T>(view);
    }

    public boolean isViewAttached(){
        return viewRef!=null&&viewRef.get()!=null;
    }

    public T getView(){
        return viewRef.get();
    }

    public void detachView(){
        if(viewRef!=null){
            viewRef.clear();
            viewRef=null;
        }
    }

    @Override
    public void showLoadView() {

    }

    @Override
    public void hideLoadView() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showNetWorkView() {

    }
}
