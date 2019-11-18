package com.bwei.base;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:9:28
 *@Description:${DESCRIPTION}
 **/public  class BasePresenter<V extends BaseActivity> {
    public V v;
    public void Attach(V v){
        this.v = v;
    }
    public void unAttach(){
        if (v!=null){
            v=null;
        }
    }

}
