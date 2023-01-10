package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class Cmt {
    private int comArtID, comUID, comID;
    private  String comm;
    private LocalDateTime comDate;

    public Cmt() {
    }

    public Cmt(int comArtID, int comUID, int comID, String comm, LocalDateTime comDate) {
        this.comArtID = comArtID;
        this.comUID = comUID;
        this.comID = comID;
        this.comm = comm;
        this.comDate = comDate;
    }

    public static int getComArtID() {
        return comArtID;
    }

    public void setComArtID(int comArtID) {
        this.comArtID = comArtID;
    }

    public static int getComUID() {
        return comUID;
    }

    public void setComUID(int comUID) {
        this.comUID = comUID;
    }

    public int getComID() {
        return comID;
    }

    public void setComID(int comID) {
        this.comID = comID;
    }

    public static String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public static LocalDateTime getComDate() {
        return comDate;
    }

    public void setComDate(LocalDateTime comDate) {
        this.comDate = comDate;
    }

    @Override
    public String toString() {
        return "Commnent{" +
                "comArtID=" + comArtID +
                ", comUID=" + comUID +
                ", comID=" + comID +
                ", comm='" + comm + '\'' +
                ", comDate=" + comDate +
                '}';
    }
}
