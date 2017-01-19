package com.fishwithcat.rxjavamvp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/12/22.
 */

public class ClockView extends View {

    private Paint mPaint;

    private int DEFAULT_COLOR= Color.WHITE;

    private int radius,padd=10;

    private PorterDuff.Mode mode;

    private PorterDuffXfermode porterDuffXfermode;

    private int BACKGROUND_COLOR=Color.GREEN;

    private int width,height;

    private enum Ratio{
        WIDTH,HEIGHT
    }

    public ClockView(Context context) {
        super(context);
        init(context);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mode=PorterDuff.Mode.DST;

        porterDuffXfermode=new PorterDuffXfermode(mode);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
        radius=(w/2-padd)/2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(BACKGROUND_COLOR);
        Log.d("Tag","半径"+radius);

        Log.d("Tag","左耳坐标"+(width/2-padd-radius/3));
        canvas.drawCircle(width/2-padd-radius/3,width/2-padd-radius/3,radius/3,mPaint);
        canvas.drawCircle(width-(width/2-padd-radius/3),width/2-padd-radius/3,radius/3,mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(width/2,height/2,radius*2/3,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getMeasureSize(widthMeasureSpec,Ratio.WIDTH),getMeasureSize(heightMeasureSpec,Ratio.HEIGHT));
    }

    private int getMeasureSize(int measureSpec,Ratio ratio){
        int result=0;
        int measureMode=MeasureSpec.getMode(measureSpec);
        int measureSize=MeasureSpec.getSize(measureSpec);

        switch (measureMode){
            case MeasureSpec.EXACTLY:
                result=measureSize;
                break;
            default:
                if(measureMode==MeasureSpec.AT_MOST){
                    if(ratio==Ratio.WIDTH){
                        result=Math.min(800,measureSize);
                    }else {
                        result=Math.min(800,measureSize);
                    }
                }else {
                    result=measureSize;
                }
                break;
        }
        return result;
    }
}
