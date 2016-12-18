package com.fishwithcat.rxjavamvp.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/12/18.
 */

public abstract class BaseActivity <V,T extends BasePresenter<V>>extends Activity {

    protected T mPresenter;

    public abstract T createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
