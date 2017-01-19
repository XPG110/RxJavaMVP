package com.fishwithcat.rxjavamvp.api;

import android.content.Context;

import java.util.HashMap;

/**
 * @Date 创建时间: 2017/1/18
 * @Author: Administrator
 * @Description:保存
 * @Version
 */

public class HttpParams<String,Object> extends HashMap <String,Object>{

    /**
     * 不带token
     * @return
     */
    public static HttpParams getInstance(){
        HttpParams httpParams=new HttpParams();
        return httpParams;
    }

    public static HttpParams getInstance(Context context){
        HttpParams httpParams=new HttpParams();
        httpParams.put("","");
        return httpParams;
    }

}
