package com.fishwithcat.rxjavamvp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Date 创建时间: 2017/1/18
 * @Author: Administrator
 * @Description:网络分页列表数据
 * @Version
 */

public class JsonPageResponse<T> extends BaseResponse {

    public Data<T> data;

    public static class Data<T>{
        /**总条数*/
        @SerializedName("total")
        public int total;
        @SerializedName("rows")
        public List<T> rows;
    }

    public List<T> getListData(){
        return data!=null?data.rows:null;
    }

}
