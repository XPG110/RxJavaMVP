package com.fishwithcat.rxjavamvp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/12/18.
 */

public class BaseResponse {

    /**错误信息**/
    @SerializedName("message")
    public String message;
    /**系统返回码*/
    @SerializedName("ret")
    public String ret;
    /**api版本**/
    @SerializedName("version")
    public int version;

    /**
     * 接口是否可用
     *
     * @Title: isDone
     * @Description: TODO
     * @return: boolean 如果返回false，可以取message说明原因
     */
    public boolean isDone(){
        if (this.ret != null) {
            return this.ret.equals("0");
        }
        return true;
    }

}
