package com.example.finalproject.beans;

public class Editor {
    private int editID, manUsID, ManCateID;

    public Editor() {
    }

    public Editor(int editID, int manUsID, int manCateID) {
        this.editID = editID;
        this.manUsID = manUsID;
        ManCateID = manCateID;
    }

    public int getEditID() {
        return editID;
    }

    public void setEditID(int editID) {
        this.editID = editID;
    }

    public int getManUsID() {
        return manUsID;
    }

    public void setManUsID(int manUsID) {
        this.manUsID = manUsID;
    }

    public int getManCateID() {
        return ManCateID;
    }

    public void setManCateID(int manCateID) {
        ManCateID = manCateID;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "editID=" + editID +
                ", manUsID=" + manUsID +
                ", ManCateID=" + ManCateID +
                '}';
    }
}
