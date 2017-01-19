package com.fishwithcat.rxjavamvp.dao;

/**
 * @Date 创建时间: 2017/1/16
 * @Author: Administrator
 * @Description:
 * @Version
 */

public class DatabaseFactory {

    private DatabaseFactory(){

    }

    public static DatabaseFactory getInstance(){
        return DatabaseFactoryHolder.instance;
    }

    private static class DatabaseFactoryHolder {
        public static DatabaseFactory instance=new DatabaseFactory();
    }
}
