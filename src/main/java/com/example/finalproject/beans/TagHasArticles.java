package com.example.finalproject.beans;

public class TagHasArticles {
    private int tagArtID, tagsID, ArtID;

    public TagHasArticles() {
    }

    public TagHasArticles(int tagArtID, int tagsID, int artID) {
        this.tagArtID = tagArtID;
        this.tagsID = tagsID;
        ArtID = artID;
    }

    public int getTagArtID() {
        return tagArtID;
    }

    public void setTagArtID(int tagArtID) {
        this.tagArtID = tagArtID;
    }

    public int getTagsID() {
        return tagsID;
    }

    public void setTagsID(int tagsID) {
        this.tagsID = tagsID;
    }

    public int getArtID() {
        return ArtID;
    }

    public void setArtID(int artID) {
        ArtID = artID;
    }

    @Override
    public String toString() {
        return "TagHasArticles{" +
                "tagArtID=" + tagArtID +
                ", tagsID=" + tagsID +
                ", ArtID=" + ArtID +
                '}';
    }
}
