package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class Articles {
    private int artID, view, cateID, wID, stt;
    private String tit, abstr, cont;
    private LocalDateTime dtime;
    private boolean pre;

    public Articles() {
    }

    public Articles(int artID, int view, int cateID, int wID, int stt, String tit, String abstr, String cont, LocalDateTime dtime, boolean pre) {
        this.artID = artID;
        this.view = view;
        this.cateID = cateID;
        this.wID = wID;
        this.stt = stt;
        this.tit = tit;
        this.abstr = abstr;
        this.cont = cont;
        this.dtime = dtime;
        this.pre = pre;
    }

    public int getArtID() {
        return artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getwID() {
        return wID;
    }

    public void setwID(int wID) {
        this.wID = wID;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getAbstr() {
        return abstr;
    }

    public void setAbstr(String abstr) {
        this.abstr = abstr;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public LocalDateTime getDtime() {
        return dtime;
    }

    public void setDtime(LocalDateTime dtime) {
        this.dtime = dtime;
    }

    public boolean isPre() {
        return pre;
    }

    public void setPre(boolean pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "artID=" + artID +
                ", view=" + view +
                ", cateID=" + cateID +
                ", wID=" + wID +
                ", stt=" + stt +
                ", tit='" + tit + '\'' +
                ", abstr='" + abstr + '\'' +
                ", cont='" + cont + '\'' +
                ", dtime=" + dtime +
                ", pre=" + pre +
                '}';
    }
}
