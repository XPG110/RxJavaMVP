package com.fishwithcat.rxjavamvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @Date 创建时间: 2017/1/16
 * @Author: Administrator
 * @Description:
 * @Version
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends Activity{

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();
        mPresenter.attachView((V) this);
    }

    public abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

}
