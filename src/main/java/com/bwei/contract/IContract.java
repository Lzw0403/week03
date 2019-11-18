package com.bwei.contract;

import java.util.Map;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:9:33
 *@Description:${DESCRIPTION}
 **/public interface IContract {
    interface MyCallBack {
        void success(String json);
        void error(String err);
    }
    interface IView{
        void success(String jsonstr);
    }
    interface IPresenter{
        void success(String url, Map<String,String> map);
    }
}
