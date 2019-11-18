package com.bwei.bean;

/*
 *@auther:李泽炜
 *@Date: 2019/11/18
 *@Time:10:01
 *@Description:${DESCRIPTION}
 **/public class Mybean {
    private String myshou;
    private String mymim;

    public Mybean(String myshou, String mymim) {
        this.myshou = myshou;
        this.mymim = mymim;
    }

    public String getMyshou() {
        return myshou;
    }

    public void setMyshou(String myshou) {
        this.myshou = myshou;
    }

    public String getMymim() {
        return mymim;
    }

    public void setMymim(String mymim) {
        this.mymim = mymim;
    }

    @Override
    public String toString() {
        return "Mybean{" +
                "myshou='" + myshou + '\'' +
                ", mymim='" + mymim + '\'' +
                '}';
    }
}
