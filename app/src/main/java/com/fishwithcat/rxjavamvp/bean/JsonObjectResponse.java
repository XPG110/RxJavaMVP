package com.fishwithcat.rxjavamvp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @Date 创建时间: 2017/1/18
 * @Author: Administrator
 * @Description:网络单条对象model
 * @Version
 */

public class JsonObjectResponse<T> extends BaseResponse {
    @SerializedName("data")
    public T data;
}
