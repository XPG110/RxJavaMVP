package com.fishwithcat.rxjavamvp.base;

import android.view.View;

import java.lang.ref.WeakReference;

/**
 * @Date 创建时间: 2017/1/16
 * @Author: Administrator
 * @Description:
 * @Version
 */

public class BasePresenter<T> implements IPresenter{

    private WeakReference<T> mWeakReference;

    public void attachView(T view){
        mWeakReference=new WeakReference<T>(view);
    }

    public boolean isAttached(){
        return mWeakReference!=null&&mWeakReference.get()!=null;
    }

    public T getView(){
        return mWeakReference.get();
    }

    public void detachView(){
        if(mWeakReference!=null) {
            mWeakReference.clear();
            mWeakReference=null;
        }
    }
}
