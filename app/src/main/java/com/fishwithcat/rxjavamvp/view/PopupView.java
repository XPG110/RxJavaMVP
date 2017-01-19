package com.fishwithcat.rxjavamvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.fishwithcat.rxjavamvp.R;
import com.fishwithcat.rxjavamvp.utils.CommonUtils;

/**
 * Created by Administrator on 2016/12/19.
 */

public class PopupView extends View {

    private Context mContext;

    private Paint mPaint;

    private Path mPath;

    private int mWidth,mHeight;

    private int color;

    public PopupView(Context context) {
        this(context,null);
    }

    public PopupView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public PopupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttr(context,attrs,defStyleAttr);
        init(context);
    }

    private void parseAttr(Context context,AttributeSet attrs,int defStyleAttr){
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.PopupView,defStyleAttr,0);
        color=a.getColor(R.styleable.PopupView_backgroundColor,0xff6950a1);
        a.recycle();
    }

    private void init(Context context){
        mContext=context;
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(color);
        mPath=new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF=new RectF(0,0,mWidth,mHeight);
        canvas.drawRoundRect(rectF,20,20,mPaint);
        mPath.moveTo(mHeight/2-30,mHeight);
        mPath.lineTo(mWidth/2+30,mHeight);
        mPath.lineTo(mWidth/2,mHeight+40);
        mPath.close();

        canvas.drawPath(mPath,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);

        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode==MeasureSpec.EXACTLY){
            mWidth=widthSize;
        }else {
            mWidth= CommonUtils.dp2px(mContext,200);
        }

        if(heightMode==MeasureSpec.EXACTLY){
            mHeight=heightSize;
        }else {
            mHeight=CommonUtils.dp2px(mContext,150);
        }

        setMeasuredDimension(mWidth,mHeight+40);
    }

}
