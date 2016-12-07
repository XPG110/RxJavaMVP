package com.fishwithcat.rxjavamvp.ui.iview;

import com.fishwithcat.rxjavamvp.bean.Article;

import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */

public interface IMainView {

    void showData(List<Article> data);

    void showLoading();

    void hindLoading();
}
