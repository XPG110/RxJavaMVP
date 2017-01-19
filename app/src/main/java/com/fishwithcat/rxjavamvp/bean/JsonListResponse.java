package com.fishwithcat.rxjavamvp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Date 创建时间: 2017/1/18
 * @Author: Administrator
 * @Description:网络列表数据集合
 * @Version
 */

public class JsonListResponse<T> extends BaseResponse {
    @SerializedName("data")
    public List<T> data;

}
