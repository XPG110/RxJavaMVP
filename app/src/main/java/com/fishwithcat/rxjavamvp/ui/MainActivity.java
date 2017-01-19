package com.fishwithcat.rxjavamvp.ui;

import android.os.Bundle;

import com.fishwithcat.rxjavamvp.R;
import com.fishwithcat.rxjavamvp.base.BaseActivity;
import com.fishwithcat.rxjavamvp.base.BasePresenter;
import com.fishwithcat.rxjavamvp.bean.GoodDetailEntity;
import com.fishwithcat.rxjavamvp.bean.GoodEntity;
import com.fishwithcat.rxjavamvp.presenter.impl.MainPresenterImpl;

import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */

public class MainActivity extends BaseActivity implements IMainView{

    private MainPresenterImpl mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public BasePresenter createPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showGoodDetail(GoodDetailEntity goodDetail) {

    }

    @Override
    public void showGood(List<GoodEntity> goodList) {

    }

    @Override
    public void hideLoading() {

    }
}
