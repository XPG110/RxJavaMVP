package com.fishwithcat.rxjavamvp.presenter.impl;

import com.fishwithcat.rxjavamvp.api.DataListener;
import com.fishwithcat.rxjavamvp.base.BasePresenter;
import com.fishwithcat.rxjavamvp.bean.GoodEntity;
import com.fishwithcat.rxjavamvp.model.CallBack;
import com.fishwithcat.rxjavamvp.model.impl.IGoodModelImpl;
import com.fishwithcat.rxjavamvp.presenter.ipresenter.IMainPresenter;
import com.fishwithcat.rxjavamvp.ui.IMainView;

import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */

public class MainPresenterImpl extends BasePresenter<IMainView> implements IMainPresenter {

    public IMainView mIMainView;

    private IGoodModelImpl goodModel;

    public MainPresenterImpl(IMainView iMainView){
        this.mIMainView=iMainView;
    }

    @Override
    public void getGoodsDetail() {
    }

    @Override
    public void getGoods() {
        goodModel.loadGood(new CallBack<List<GoodEntity>>() {
            @Override
            public void onSuccess(List<GoodEntity> response) {

            }

            @Override
            public void onFail() {

            }
        });
    }
}
