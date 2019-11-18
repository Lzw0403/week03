package com.bwei.lizewei20191118;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bwei.base.BaseActivity;
import com.bwei.base.BasePresenter;
import com.bwei.bean.Mybean;
import com.bwei.presenter.MyPresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private EditText ed_phone;
    private EditText ed_pwd;
    private Button bu_zhu;
    private Button bu_deng;
    private MyPresenter myPresenter;
    private Mybean mybean;
    private String onesh;
    private String twomi;

    @Override
    protected void initData() {
        //登录
        bu_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onesh = ed_phone.getText().toString().trim();
                twomi = ed_pwd.getText().toString().trim();
                Map<String,String> map = new HashMap<>();
                map.put("phone",onesh);
                map.put("pwd",twomi);
                myPresenter.success("http://172.17.8.100/small/user/v1/login",map);
            }
        });
        //注册
        bu_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //startActivity(intent);
                startActivityForResult(intent,2000);
            }
        });
    }

    @Override
    protected void initView() {
        ed_phone = findViewById(R.id.ed_phone);
        ed_pwd = findViewById(R.id.ed_pwd);
        bu_zhu = findViewById(R.id.bu_zhu);
        bu_deng = findViewById(R.id.bu_deng);
    }

    @Override
    protected BasePresenter initPresenter() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(String jsonstr) {
        Gson gson = new Gson();
        mybean = gson.fromJson(jsonstr, Mybean.class);
        String mymim = mybean.getMymim();
        if (mymim.equals("0000")){
            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
            intent.putExtra("phone",onesh);
            intent.putExtra("pwd",twomi);
            startActivity(intent);
        }
    }
}
