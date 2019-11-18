package com.bwei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bwei.contract.IContract;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:9:26
 *@Description:${DESCRIPTION}
 **/public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContract.IView {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        p = initPresenter();
        if (p!=null){
            p.Attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unAttach();
            p=null;
        }
    }
}
