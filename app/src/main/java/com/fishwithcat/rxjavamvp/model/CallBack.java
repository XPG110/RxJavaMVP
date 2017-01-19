package com.fishwithcat.rxjavamvp.model;

/**
 * @Date 创建时间: 2017/1/18
 * @Author: Administrator
 * @Description:
 * @Version
 */

public interface CallBack<T> {
    /**
     * 数据读取成功
     * @param response
     */
    void onSuccess(T response);

    /**
     * 数据读取失败
     */
    void onFail();
}
