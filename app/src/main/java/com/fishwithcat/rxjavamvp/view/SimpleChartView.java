package com.fishwithcat.rxjavamvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.fishwithcat.rxjavamvp.R;
import com.fishwithcat.rxjavamvp.utils.CommonUtils;

import java.util.List;

/**
 * @Date 创建时间: 2016/12/29
 * @Author: Administrator
 * @Description: 简易表单控件
 * @Version
 */

public class SimpleChartView extends View {

    private Context mContext;

    private Paint textPaint;

    private Paint linePaint;

    private List<String> mXResouce;
    private List<String> mYResouce;

    private int mWidth,mHeight;

    private int textSize;
    private int textColor;
    private int lineColor;

    public SimpleChartView(Context context) {
        this(context,null);
    }

    public SimpleChartView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SimpleChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttrs(context,attrs,defStyleAttr);
        init(context);
    }

    private void parseAttrs(Context context,AttributeSet attrs,int defStyleAttr){
        TypedArray array=context.obtainStyledAttributes(attrs,R.styleable.SimpleChartView,defStyleAttr,0);
        textColor=array.getColor(R.styleable.SimpleChartView_textColor,0xff6950a1);
        lineColor=array.getColor(R.styleable.SimpleChartView_lineColor,0xff6950a1);
        textSize=array.getDimensionPixelSize(R.styleable.SimpleChartView_textSize, CommonUtils.sp2px(context,14));
        array.recycle();
    }

    private void init(Context context){
        mContext=context;
        textPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);

        textPaint.setColor(textColor);
        linePaint.setColor(lineColor);

        textPaint.setTextSize(textSize);
    }

    public void setXResource(List<String> data){
        mXResouce=data;
        invalidate();
    }

    public void setYResource(List<String> data){
        mYResouce=data;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int xCount=mXResouce.size();
        for (int i=0;i<xCount;i++){
            canvas.drawText(mXResouce.get(i),mWidth/xCount*i,mHeight,textPaint);
        }
        int yCount = mXResouce.size();
        for (int j=0;j<yCount;j++){
            canvas.drawText(mYResouce.get(yCount-j-1),0,mHeight/yCount*j,textPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);

        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode==MeasureSpec.EXACTLY){
            mWidth=widthSize;
        }else if (widthMode==MeasureSpec.AT_MOST){
            mWidth=300;
        }

        if(heightMode==MeasureSpec.EXACTLY){
            mHeight=heightSize;
        }else if(heightMode==MeasureSpec.AT_MOST){
            mHeight=300;
        }
        setMeasuredDimension(mWidth,mHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
