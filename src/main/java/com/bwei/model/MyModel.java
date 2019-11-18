package com.bwei.model;

import com.android.volley.toolbox.Volley;
import com.bwei.contract.IContract;
import com.bwei.util.Volleyutil;

import java.util.Map;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:9:39
 *@Description:${DESCRIPTION}
 **/public class MyModel{
     public void DoPost(String url, Map<String,String>map, IContract.MyCallBack myCallBack){
         Volleyutil.getInstance().toPost(url,map,myCallBack);
     }
}
