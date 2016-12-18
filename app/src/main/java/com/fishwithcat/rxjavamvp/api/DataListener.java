package com.fishwithcat.rxjavamvp.api;

import com.fishwithcat.rxjavamvp.model.BaseResponse;

/**
 * Created by Administrator on 2016/12/18.
 */

public interface DataListener<T> {

    void onSuccess(T response);

    void onDefeate();

    void onCancel();
}
