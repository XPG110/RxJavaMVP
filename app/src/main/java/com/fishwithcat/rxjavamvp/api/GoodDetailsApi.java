package com.fishwithcat.rxjavamvp.api;

import com.fishwithcat.rxjavamvp.api.apiservice.BaseApi;
import com.fishwithcat.rxjavamvp.api.apiservice.GoodDetailsService;
import com.fishwithcat.rxjavamvp.bean.GoodDetailEntity;

/**
 * Created by Administrator on 2016/12/18.
 */

public class GoodDetailsApi extends BaseApi<GoodDetailEntity>{

    GoodDetailsService service;

    private GoodDetailsApi(){
        super();
        service= ApiConfig.ISTEST?ApiConfig.getInstance().getRetrofit().create(GoodDetailsService.class)
                :ApiConfig.getInstance().getRetrofit("").create(GoodDetailsService.class);
    }

    public static GoodDetailsApi getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
        public static GoodDetailsApi instance=new GoodDetailsApi();
    }

    public void getGoodDetailsData(DataListener dataListener){
        request(service.getGoodDetailsData(), new Splice<GoodDetailEntity>() {
            @Override
            public void onNext(GoodDetailEntity goodDetailEntity) {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onCancel() {

            }
        });
    }
}
