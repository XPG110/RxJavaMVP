package com.fishwithcat.rxjavamvp.presenter.impl;

import com.fishwithcat.rxjavamvp.api.DataListener;
import com.fishwithcat.rxjavamvp.api.GoodDetailsApi;
import com.fishwithcat.rxjavamvp.base.BasePresenter;
import com.fishwithcat.rxjavamvp.model.BaseResponse;
import com.fishwithcat.rxjavamvp.model.GoodDetailEntity;
import com.fishwithcat.rxjavamvp.presenter.ipresenter.IMainPresenter;
import com.fishwithcat.rxjavamvp.ui.IMainView;

/**
 * Created by Administrator on 2016/12/18.
 */

public class MainPresenterImpl extends BasePresenter<IMainView> implements IMainPresenter {

    public IMainView mIMainView;

    public MainPresenterImpl(IMainView iMainView){
        this.mIMainView=iMainView;
    }

    @Override
    public void getGoodsDetail() {
        showLoadView();
        GoodDetailsApi.getInstance().getGoodDetailsData(new DataListener<GoodDetailEntity>() {
            @Override
            public void onSuccess(GoodDetailEntity response) {
                if(response.ret==200){
                    hideLoadView();
                    mIMainView.showGoodDetail(response);
                }else {
                    showErrorView();
                }
            }

            @Override
            public void onDefeate() {
                showNetWorkView();
            }

            @Override
            public void onCancel() {
            }
        });
    }
}
