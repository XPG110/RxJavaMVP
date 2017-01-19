package com.fishwithcat.rxjavamvp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.fishwithcat.rxjavamvp.R;
import com.fishwithcat.rxjavamvp.bean.GoodDetailEntity;
import com.fishwithcat.rxjavamvp.view.CirclePercentView;
import com.fishwithcat.rxjavamvp.view.SimpleChartView;

import java.util.Arrays;
import java.util.List;

/**
 * @Date 创建时间: 2017/1/16
 * @Author: Administrator
 * @Description:
 * @Version
 */

public class TestViewActivity extends Activity {

    public GoodDetailEntity good;
    private SeekBar seekBar;
    private CirclePercentView circlePercentView;
    private SimpleChartView simpleChartView;
    private List<String> xResource= Arrays.asList("1","2","3","4");
    private List<String> yResource=Arrays.asList("5K","8K","12K","20K");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);

        seekBar= (SeekBar) findViewById(R.id.seekBar);
        circlePercentView= (CirclePercentView) findViewById(R.id.circlePercentView);
        simpleChartView= (SimpleChartView) findViewById(R.id.simpleChartView);
        simpleChartView.setXResource(xResource);
        simpleChartView.setYResource(yResource);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circlePercentView.setPersent(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}
