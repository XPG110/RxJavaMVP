package com.fishwithcat.rxjavamvp.api;

/**
 * Created by Administrator on 2016/12/18.
 */

public class GoodDetailsApi {

    private GoodDetailsApi(){

    }

    public static GoodDetailsApi getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
        public static GoodDetailsApi instance=new GoodDetailsApi();
    }

    public void getGoodDetailsData(DataListener dataListener){

    }
}
