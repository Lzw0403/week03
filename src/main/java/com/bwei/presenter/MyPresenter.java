package com.bwei.presenter;

import com.bwei.base.BasePresenter;
import com.bwei.contract.IContract;
import com.bwei.model.MyModel;

import java.util.Map;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:9:39
 *@Description:${DESCRIPTION}
 **/public class MyPresenter extends BasePresenter implements IContract.IPresenter {
    MyModel myModel;

    public MyPresenter() {
        myModel = new MyModel();
    }

    @Override
    public void success(String url, Map<String, String> map) {
        myModel.DoPost(url, map, new IContract.MyCallBack() {
            @Override
            public void success(String json) {
                v.success(json);
            }

            @Override
            public void error(String err) {

            }
        });
    }
}
