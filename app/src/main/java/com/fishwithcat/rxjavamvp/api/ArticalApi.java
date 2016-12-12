package com.fishwithcat.rxjavamvp.api;

/**
 * Created by Administrator on 2016/12/7.
 */

public class ArticalApi extends BaseApi{


    private ArticalApi(){

    }

    @Override
    protected void initData() {
        super.initData();

    }

    public static ArticalApi getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
        public static ArticalApi instance=new ArticalApi();
    }

    public void fetchArtical(DataListener listener){
    }
}
