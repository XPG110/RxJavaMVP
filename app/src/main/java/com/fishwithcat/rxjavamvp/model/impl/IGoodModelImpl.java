package com.fishwithcat.rxjavamvp.model.impl;


import com.fishwithcat.rxjavamvp.api.DataListener;
import com.fishwithcat.rxjavamvp.bean.GoodEntity;
import com.fishwithcat.rxjavamvp.model.CallBack;
import com.fishwithcat.rxjavamvp.model.imodel.IGoodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 创建时间: 2017/1/18
 * @Author: Administrator
 * @Description:
 * @Version
 */

public class IGoodModelImpl implements IGoodModel<List<GoodEntity>> {
    @Override
    public void loadGood(CallBack<List<GoodEntity>> listener) {
        List<GoodEntity> data=new ArrayList<>();
        listener.onSuccess(data);
    }
}
