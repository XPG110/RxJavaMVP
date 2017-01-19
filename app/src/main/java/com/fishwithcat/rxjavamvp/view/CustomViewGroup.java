package com.fishwithcat.rxjavamvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Date 创建时间: 2017/1/9
 * @Author: Administrator
 * @Description:
 * @Version
 */

public class CustomViewGroup extends ViewGroup {

    private Context mContext;

    public CustomViewGroup(Context context) {
        this(context,null);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int result=0;
        for(int i=0;i<getChildCount();i++) {
            View childView = getChildAt(i);
        }


    }
}
