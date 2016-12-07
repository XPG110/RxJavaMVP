package com.fishwithcat.rxjavamvp.ui;

import android.os.Bundle;

import com.fishwithcat.rxjavamvp.R;
import com.fishwithcat.rxjavamvp.base.BaseActivity;
import com.fishwithcat.rxjavamvp.bean.Article;
import com.fishwithcat.rxjavamvp.presenter.impl.MainPresenterImpl;
import com.fishwithcat.rxjavamvp.ui.iview.IMainView;

import java.util.List;

public class MainActivity extends BaseActivity<IMainView,MainPresenterImpl> implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public MainPresenterImpl createPresnter() {
        return new MainPresenterImpl(this);
    }

    private void initView(){

    }

    @Override
    public void showData(List<Article> data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hindLoading() {

    }

}
