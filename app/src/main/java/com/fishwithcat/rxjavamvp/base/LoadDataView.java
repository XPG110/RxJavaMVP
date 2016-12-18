package com.fishwithcat.rxjavamvp.base;

/**
 * Created by Administrator on 2016/12/18.
 */

public interface LoadDataView {

    /**
     * 显示加载中View
     */
    void showLoadView();

    /**
     * 隐藏加载中View
     */
    void hideLoadView();

    /**
     * x显示空数据View
     */
    void showEmptyView();

    /**
     * 显示数据加载错误View
     */
    void showErrorView();

    /**
     * 显示网络异常View
     */
    void showNetWorkView();

}
