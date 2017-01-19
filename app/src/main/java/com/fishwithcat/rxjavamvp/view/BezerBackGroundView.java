package com.fishwithcat.rxjavamvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/12/20.
 */

public class BezerBackGroundView extends View {

    private Paint mPaintBezier;
    private Paint mPaintAuxiliary;
    private Paint mPaintAuxiliaryText;

    private float mAuxiliaryX;
    private float mAuxiliaryY;

    private float mStartPointX;
    private float mStartPointY;

    private float mEndPointX;
    private float mEndPointY;


    private Path mPath = new Path();


    private enum Ratio{
        WIDTH,HEIGHT
    }

    public BezerBackGroundView(Context context) {
        super(context);
        init(context);
    }

    public BezerBackGroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BezerBackGroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaintBezier = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBezier.setStyle(Paint.Style.FILL);
        mPaintBezier.setStrokeWidth(8);

        mPaintAuxiliary = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintAuxiliary.setStyle(Paint.Style.STROKE);
        mPaintAuxiliary.setStrokeWidth(2);

        mPaintAuxiliaryText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintAuxiliaryText.setStyle(Paint.Style.STROKE);
        mPaintAuxiliaryText.setTextSize(20);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mStartPointX = w / 4;
        mStartPointY = h / 2 ;

        mEndPointX = w / 4 * 3;
        mEndPointY = h / 2 ;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        mPath.moveTo(mStartPointX, mStartPointY);

        // 辅助点
        canvas.drawPoint(mAuxiliaryX, mAuxiliaryY, mPaintAuxiliary);
        canvas.drawText("控制点", mAuxiliaryX, mAuxiliaryY, mPaintAuxiliaryText);
        canvas.drawText("起始点", mStartPointX, mStartPointY, mPaintAuxiliaryText);
        canvas.drawText("终止点", mEndPointX, mEndPointY, mPaintAuxiliaryText);
        // 辅助线
        canvas.drawLine(mStartPointX, mStartPointY, mAuxiliaryX, mAuxiliaryY, mPaintAuxiliary);
        canvas.drawLine(mEndPointX, mEndPointY, mAuxiliaryX, mAuxiliaryY, mPaintAuxiliary);
        // 二阶贝塞尔曲线
        mPath.quadTo(mAuxiliaryX, mAuxiliaryY, mEndPointX, mEndPointY);

        canvas.drawPath(mPath, mPaintBezier);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mAuxiliaryX = event.getX();
                mAuxiliaryY = event.getY();
                invalidate();
        }
        return true;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getMeasuredSize(widthMeasureSpec,Ratio.WIDTH),getMeasuredSize(heightMeasureSpec,Ratio.HEIGHT));
    }

    private int getMeasuredSize(int measrueSpec,Ratio ratio){
        int result=0;

        int measureMode=MeasureSpec.getMode(measrueSpec);

        int measureSize=MeasureSpec.getSize(measrueSpec);

        switch (measureMode){
            case MeasureSpec.EXACTLY:
                result=measureSize;
                break;
            default:
                if(measureMode==MeasureSpec.AT_MOST){
                    if(ratio==Ratio.WIDTH){
                        result=400;
                        result=Math.min(measureSize,result);
                    }else {
                        result=400;
                        result=Math.min(measureSize,result);
                    }
                }else{
                    if(ratio==Ratio.WIDTH){
                        result=300;
                    }else {
                        result=200;
                    }
                }
                break;
        }
        return result;
    }

}
