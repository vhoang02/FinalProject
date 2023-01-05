package com.example.finalproject.beans;

public class Category {
    private int catID, parID;
    private  String cateName;

    public Category() {
    }

    public Category(int catID, int parID, String cateName) {
        this.catID = catID;
        this.parID = parID;
        this.cateName = cateName;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getParID() {
        return parID;
    }

    public void setParID(int parID) {
        this.parID = parID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catID=" + catID +
                ", parID=" + parID +
                ", cateName='" + cateName + '\'' +
                '}';
    }
}
