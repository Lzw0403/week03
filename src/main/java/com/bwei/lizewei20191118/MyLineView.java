package com.bwei.lizewei20191118;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:10:45
 *@Description:${DESCRIPTION}
 **/public class MyLineView extends View {
    private int width;
    private int height;
    private Paint linePaint;
    private Paint textPaint;
    private Paint ponePaint;

    public MyLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void init(){
        linePaint = new Paint();
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setColor(Color.RED);
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth((float) 2.0);
        textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setStrokeWidth((float) 2.0);
        ponePaint = new Paint();
        ponePaint.setStrokeWidth((float) 2.0);
        ponePaint.setStyle(Paint.Style.STROKE);
        ponePaint.setColor(Color.RED);

    }
}
