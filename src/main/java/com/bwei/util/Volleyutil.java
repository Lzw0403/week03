package com.bwei.util;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwei.app.MyApp;
import com.bwei.contract.IContract;

import java.util.Map;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:9:42
 *@Description:${DESCRIPTION}
 **/public class Volleyutil {
    //单例模式
    private static Volleyutil volleyutil;
    private final RequestQueue queue;

    private Volleyutil() {
        queue = Volley.newRequestQueue(MyApp.context);
    }

    public static Volleyutil getInstance(){
        if (volleyutil==null){
            volleyutil = new Volleyutil();
        }
            return volleyutil;
    }
    //Get请求
    public void toGet(String url, final IContract.MyCallBack myCallBack){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.error(error.getMessage());
            }
        });
        queue.add(request);
    }
    //Post请求
    public void toPost(String url, final Map<String,String> map, final IContract.MyCallBack myCallBack){
        StringRequest request = new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                myCallBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                myCallBack.error(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        queue.add(request);
    }
}
