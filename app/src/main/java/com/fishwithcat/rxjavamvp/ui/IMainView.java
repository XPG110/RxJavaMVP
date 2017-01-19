package com.fishwithcat.rxjavamvp.ui;

import com.fishwithcat.rxjavamvp.bean.GoodDetailEntity;
import com.fishwithcat.rxjavamvp.bean.GoodEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */

public interface IMainView {

    void showLoading();

    void showGoodDetail(GoodDetailEntity goodDetail);

    void showGood(List<GoodEntity> goodList);

    void hideLoading();

}
