package com.fishwithcat.rxjavamvp.api;


/**
 * Created by Administrator on 2016/12/18.
 */

public interface DataListener<T> {

    /**
     * 数据读取成功
     * @param response
     */
    void onSuccess(T response);

    /**
     * 数据读取失败
     */
    void onFail();

    /**
     * 取消
     */
    void onCancel();
}
