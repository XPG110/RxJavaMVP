package com.fishwithcat.rxjavamvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/12/19.
 */

public class MyApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }

    public static Context getContext(){
        return mContext;
    }
}
