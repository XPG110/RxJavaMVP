package com.fishwithcat.rxjavamvp.model.impl;

import com.fishwithcat.rxjavamvp.bean.Article;
import com.fishwithcat.rxjavamvp.model.IArticalModel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */

public class ArticalModelImpl implements IArticalModel {

    List<Article> articles=new LinkedList<>();

    @Override
    public void saveArticle(List<Article> data) {
        articles.addAll(data);
    }

    @Override
    public void loadArticFromCache() {

    }
}
