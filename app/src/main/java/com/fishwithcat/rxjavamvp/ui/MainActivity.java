package com.fishwithcat.rxjavamvp.ui;

import android.app.Activity;
import android.os.Bundle;

import com.fishwithcat.rxjavamvp.R;
import com.fishwithcat.rxjavamvp.base.BaseActivity;
import com.fishwithcat.rxjavamvp.model.GoodDetailEntity;
import com.fishwithcat.rxjavamvp.presenter.impl.MainPresenterImpl;

/**
 * Created by Administrator on 2016/12/18.
 */

public class MainActivity extends BaseActivity<IMainView,MainPresenterImpl> implements IMainView{

    public GoodDetailEntity good;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.getGoodsDetail();
    }

    @Override
    public void showGoodDetail(GoodDetailEntity goodDetail) {
        good=goodDetail;
    }

    @Override
    public MainPresenterImpl createPresenter() {
        return new MainPresenterImpl(this);
    }
}
