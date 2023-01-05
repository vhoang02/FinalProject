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

    public Tag(String value) {
        this.tag_id = -1;
        this.value = value;
    }


    public int getTagID() {
        return tag_id;
    }

    public void setTagID(int tagID) {
        this.tag_id = tagID;
    }

    public String getVal() {
        return value;
    }

    public void setVal(String val) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagID=" + tag_id +
                ", value='" + value + '\'' +
                '}';
    }
}
