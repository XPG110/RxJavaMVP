package com.fishwithcat.rxjavamvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.fishwithcat.rxjavamvp.R;
import com.fishwithcat.rxjavamvp.utils.CommonUtils;

/**
 * @Date 创建时间: 2016/12/28
 * @Author: Administrator
 * @Description:
 * @Version
 */

public class CirclePercentView extends View {

    private int mRadius;

    private Paint mBigPaint;

    private Paint mSectorPaint;

    private Paint smallPaint;

    private Paint textPaint;

    private Context mContext;

    private int mStripWidth;

    private int smallColor;

    private int bigColor;

    private float mPercent;

    //圆心坐标
    private float x;
    private float y;

    private int mEndAngle;

    private int mWidth;

    private int mHeight;

    private int mTextSize;

    public CirclePercentView(Context context) {
        this(context,null);
    }

    public CirclePercentView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CirclePercentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttrs(context,attrs,defStyleAttr);
        init(context);
    }

    private void parseAttrs(Context context,AttributeSet attrs, int defStyleAttr){
        // 获取自定义属性
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.CirclePercentView, defStyleAttr, 0);

        smallColor=a.getColor(R.styleable.CirclePercentView_smallColor,0xffafb4db);
        bigColor=a.getColor(R.styleable.CirclePercentView_bigColor,0xff6950a1);
        mRadius=a.getDimensionPixelSize(R.styleable.CirclePercentView_radius,CommonUtils.dp2px(context,100));
        mPercent=a.getInteger(R.styleable.CirclePercentView_percent,0);
        mStripWidth=a.getDimensionPixelSize(R.styleable.CirclePercentView_stripWidth,CommonUtils.dp2px(context,30));
        mTextSize=a.getDimensionPixelSize(R.styleable.CirclePercentView_textSize, CommonUtils.sp2px(context,20));
        a.recycle();
    }

    private void init(Context context) {
        mContext=context;
        mBigPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mBigPaint.setColor(bigColor);

        smallPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        smallPaint.setColor(bigColor);

        mSectorPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mSectorPaint.setColor(smallColor);

        textPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mEndAngle= (int) (mPercent*3.6);

        canvas.drawCircle(x,y,mRadius,mBigPaint);

        RectF rectF=new RectF(0,0,mWidth,mHeight);
        canvas.drawArc(rectF,270,mEndAngle,true,mSectorPaint);

        canvas.drawCircle(x,y,mRadius-mStripWidth,smallPaint);

        String text=mPercent+"%";
        textPaint.setTextSize(mTextSize);
        float textWidth=textPaint.measureText(text);
        canvas.drawText(text,x-textWidth/2,y,textPaint);
    }

    public void setPersent(final int percent){
        mPercent = percent;
        postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //获取测量模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //获取测量大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //如果为确定大小值，则圆的半径为宽度/2
        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            mRadius = widthSize / 2;
            x = widthSize / 2;
            y = heightSize / 2;
            mWidth = widthSize;
            mHeight = heightSize;
        }
        //如果为wrap_content 那么View大小为圆的半径大小*2
        if(widthMode == MeasureSpec.AT_MOST && heightMode ==MeasureSpec.AT_MOST){
            mWidth = (int) (mRadius*2);
            mHeight = (int) (mRadius*2);
            x = mRadius;
            y = mRadius;

        }
        //设置视图的大小
        setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(Math.abs(x-mRadius)<4){
                    return true;
                }else {

                }
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

}

