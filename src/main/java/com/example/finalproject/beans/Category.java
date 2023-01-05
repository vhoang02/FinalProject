package com.example.finalproject.beans;

public class Category {
    private int cat_id;
    private  String cat_name;

    private int parent_id;

    public Category() {
    }

    public Category(int cat_id, String cat_name, int parent_id) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
        this.parent_id = parent_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
}
