package com.fishwithcat.rxjavamvp.presenter.impl;

import com.fishwithcat.rxjavamvp.api.ArticalApi;
import com.fishwithcat.rxjavamvp.base.BasePresenter;
import com.fishwithcat.rxjavamvp.model.impl.ArticalModelImpl;
import com.fishwithcat.rxjavamvp.presenter.ipresenter.IMainPresenter;
import com.fishwithcat.rxjavamvp.ui.iview.IMainView;

/**
 * Created by Administrator on 2016/12/6.
 */

public class MainPresenterImpl extends BasePresenter<IMainView> implements IMainPresenter {

    IMainView iMainView;

    ArticalModelImpl mArticalModelImp=new ArticalModelImpl();


    public MainPresenterImpl(IMainView iMainView) {
        this.iMainView = iMainView;
    }

    @Override
    public void fetchArtical() {
        ArticalApi.
    }

    @Override
    public void loadDataFromDB() {

    }
}
