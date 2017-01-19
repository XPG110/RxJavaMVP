package com.fishwithcat.rxjavamvp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/12/21.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class PorterDuffXfermodeView extends View{

    private static final PorterDuff.Mode mode=PorterDuff.Mode.DARKEN;

    private PorterDuffXfermode porterDuffXfermode;

    private PorterDuffBo porterDuffBo;

    private int leftRectL,leftRectH;

    private int rightRectL,rightRectH;

    private int centerRectL,centerRectH;

    private Paint mPaint;

    private enum Ratio{
        WIDTH,HEIGHT
    }

    public PorterDuffXfermodeView(Context context) {
        super(context);
        init(context);
    }

    public PorterDuffXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PorterDuffXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        porterDuffXfermode=new PorterDuffXfermode(mode);
        porterDuffBo=new PorterDuffBo();
        // 实例化画笔并设置抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        leftRectL=w/4;
        leftRectH=h/4;
        rightRectL=w*3/4;
        rightRectH=h/4;

        centerRectL=w/2;
        centerRectH=h/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置画布颜色为黑色以便我们更好地观察
        canvas.drawColor(Color.BLACK);

        porterDuffBo.setSize(200);

        canvas.drawBitmap(porterDuffBo.initSrcBitmap(),leftRectL,leftRectH,mPaint);
        canvas.drawBitmap(porterDuffBo.initDisBitmap(),rightRectL,rightRectH,mPaint);

        int src=canvas.saveLayer(0, 0, leftRectL*4, leftRectH*4, null, Canvas.ALL_SAVE_FLAG);
        porterDuffBo.setSize(300);
        // 先绘制dis目标图
        canvas.drawBitmap(porterDuffBo.initSrcBitmap(),centerRectL,centerRectH,mPaint);
        mPaint.setXfermode(porterDuffXfermode);
        canvas.drawBitmap(porterDuffBo.initDisBitmap(),centerRectL,centerRectH,mPaint);
        canvas.restoreToCount(src);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getMeasureSize(widthMeasureSpec,Ratio.WIDTH),getMeasureSize(heightMeasureSpec,Ratio.HEIGHT));
    }

    private int getMeasureSize(int measureSpec,Ratio ratio){
        int result=0;

        int measureSize=MeasureSpec.getSize(measureSpec);

        int measureMode=MeasureSpec.getMode(measureSpec);

        switch (measureMode){
            case MeasureSpec.EXACTLY:
                result=measureSize;
                break;
            default:
                if(measureMode==MeasureSpec.AT_MOST){
                    if(ratio==Ratio.WIDTH){
                        result=Math.min(500,measureSize);
                    }else {
                        result=Math.min(500,measureSize);
                    }
                }else {
                    result=measureSize;
                }
                break;
        }

        return result;
    }

    public class PorterDuffBo{
        private int size;
        private Point mPoint;

        public PorterDuffBo() {
            mPoint = new Point();
        }

        public void setSize(int size) {
            this.size = size;
            mPoint.set(size, size);
        }

        public Bitmap initSrcBitmap() {
            int[] pixels = new int[mPoint.x * mPoint.y];
            int dst = 0;
            for (int row = 0; row < mPoint.y; ++row) {
                for (int col = 0; col < mPoint.x; ++col) {
                    pixels[dst++] = color((float) (mPoint.y - row) / mPoint.y, (float) (mPoint.x - col) / mPoint.x, (float) (mPoint.x - col) / mPoint.x, (float) col / mPoint.x);
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(pixels, size, size, Bitmap.Config.ARGB_8888);
            return bitmap;
        }

        public Bitmap initDisBitmap() {
            int[] pixels = new int[mPoint.x * mPoint.y];
            int dst = 0;
            for (int row = 0; row < mPoint.y; ++row) {
                for (int col = 0; col < mPoint.x; ++col) {
                    pixels[dst++] = color((float) (mPoint.x - col) / mPoint.x, (float) (mPoint.y - row) / mPoint.x, (float) row / mPoint.y, (float) row / mPoint.y);
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(pixels, size, size, Bitmap.Config.ARGB_8888);
            return bitmap;
        }

        private int color(float Alpha, float R, float G, float B) {
            return (int) (Alpha * 255) << 24 | (int) (R * Alpha * 255) << 16 | (int) (G * Alpha * 255) << 8 | (int) (B * Alpha * 255);
        }

    }
}
