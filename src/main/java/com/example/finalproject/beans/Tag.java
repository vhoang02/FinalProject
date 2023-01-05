package com.example.finalproject.beans;

public class Tag {
    private int tag_id;
    private String value;

    public Tag() {
    }

    public Tag(int tag_id, String value) {
        this.tag_id = tag_id;
        this.value = value;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
