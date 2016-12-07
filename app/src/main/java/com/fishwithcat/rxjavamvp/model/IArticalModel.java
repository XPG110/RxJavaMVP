package com.fishwithcat.rxjavamvp.model;

import com.fishwithcat.rxjavamvp.bean.Article;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */

public interface IArticalModel {

    void saveArticle(List<Article> data);

    void loadArticFromCache();
}
