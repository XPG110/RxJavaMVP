package com.fishwithcat.rxjavamvp.api.apiservice;

import com.fishwithcat.rxjavamvp.bean.GoodDetailEntity;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/19.
 */

public interface GoodDetailsService {

    @POST("www.baidu.com")
    Observable<GoodDetailEntity> getGoodDetailsData();
}
