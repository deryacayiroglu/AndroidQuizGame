package com.h5190004.derya_cayiroglu.model;

public class OyuncuModel {

    private String oyuncuAdi = "";
    private int puan = 0;

    public OyuncuModel(){

    }
    public OyuncuModel(String adi, int puan) {
        this.oyuncuAdi = adi;
        this.puan = puan;
    }

    public String getAdi() {
        return oyuncuAdi;
    }

    public void setAdi(String adi) {
        this.oyuncuAdi = adi;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
}
