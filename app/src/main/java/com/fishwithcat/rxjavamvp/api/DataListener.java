package com.fishwithcat.rxjavamvp.api;

/**
 * Created by Administrator on 2016/12/7.
 */

public interface DataListener {

    void onSuccess();

    void onFail();

    void onCancel();
}
