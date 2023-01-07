package com.example.finalproject.beans;

public class TagHasArticles {
    private int tag_articles_id, tagsArti_id, articlesTag_id;

    public TagHasArticles() {
    }

    public TagHasArticles(int tag_articles_id, int tagsArti_id, int articlesTag_id) {
        this.tag_articles_id = tag_articles_id;
        this.tagsArti_id = tagsArti_id;
        this.articlesTag_id = articlesTag_id;
    }

    public int getTag_articles_id() {
        return tag_articles_id;
    }

    public void setTag_articles_id(int tag_articles_id) {
        this.tag_articles_id = tag_articles_id;
    }

    public int getTagsArti_id() {
        return tagsArti_id;
    }

    public void setTagsArti_id(int tagsArti_id) {
        this.tagsArti_id = tagsArti_id;
    }

    public int getArticlesTag_id() {
        return articlesTag_id;
    }

    public void setArticlesTag_id(int articlesTag_id) {
        this.articlesTag_id = articlesTag_id;
    }
}
