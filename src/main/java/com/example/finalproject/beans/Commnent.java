package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class Commnent {
    private int comArtID, comUID, comID;
    private  String comm;
    private LocalDateTime comDate;

    public Commnent() {
    }

    public Commnent(int comArtID, int comUID, int comID, String comm, LocalDateTime comDate) {
        this.comArtID = comArtID;
        this.comUID = comUID;
        this.comID = comID;
        this.comm = comm;
        this.comDate = comDate;
    }

    public int getComArtID() {
        return comArtID;
    }

    public void setComArtID(int comArtID) {
        this.comArtID = comArtID;
    }

    public int getComUID() {
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

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public LocalDateTime getComDate() {
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
