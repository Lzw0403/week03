package com.bwei.lizewei20191118;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class Main2Activity extends BaseActivity {
    private EditText ed_one;
    private EditText ed_two;
    private Button bu_one;
    private MyPresenter myPresenter;
    private String one;
    private String two;

    @Override
    protected void initData() {
        bu_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one = ed_one.getText().toString().trim();
                Log.i("aaa", "onClick: "+one);
                two = ed_two.getText().toString().trim();
                Log.i("aaa", "onClick: "+two);
                Map<String,String> map = new HashMap<>();
                map.put("phone",one);
                map.put("pwd",two);
                myPresenter.success("http://172.17.8.100/small/user/v1/register",map);
            }
        });
    }

    @Override
    protected void initView() {
        ed_one = findViewById(R.id.ed_one);
        ed_two = findViewById(R.id.ed_two);
        bu_one = findViewById(R.id.bu_one);
    }

    @Override
    protected BasePresenter initPresenter() {
        myPresenter = new MyPresenter();
        return myPresenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void success(String jsonstr) {
        Gson gson = new Gson();
        Mybean mybean = gson.fromJson(jsonstr, Mybean.class);
        String mymim = mybean.getMymim();
        if (mymim.equals("0000")||mymim.equals("1001")){
            Intent intent = new Intent(Main2Activity.this,MainActivity.class);
            intent.putExtra("phone",one);
            intent.putExtra("pwd",two);
            //startActivity(intent);
            setResult(2000,intent);
            finish();
        }
    }
}
