package com.fishwithcat.rxjavamvp.model.imodel;

import com.fishwithcat.rxjavamvp.api.DataListener;
import com.fishwithcat.rxjavamvp.model.CallBack;

/**
 * @Date 创建时间: 2017/1/18
 * @Author: Administrator
 * @Description:数据管理层
 * @Version
 */

public interface IGoodModel<T> {

    void loadGood(CallBack<T> listener);

}
