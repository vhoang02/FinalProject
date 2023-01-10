package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class Articles {
    private int articles_id, views, categories_id, writer_id, status;
    private String title, abstracts, content;
    private LocalDateTime publish_date;
    private boolean premium;


    public Articles() {
    }

    public Articles(int articles_id, String title, LocalDateTime publish_date,  int views, String abstracts, String content, int categories_id, boolean premium, int writer_id, int status) {
        this.articles_id = articles_id;
        this.views = views;
        this.categories_id = categories_id;
        this.writer_id = writer_id;
        this.status = status;
        this.title = title;
        this.abstracts = abstracts;
        this.content = content;
        this.publish_date = publish_date;
        this.premium = premium;

    }

    public int getArticles_id() {
        return articles_id;
    }

    public void setArticles_id(int articles_id) {
        this.articles_id = articles_id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public int getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDateTime publish_date) {
        this.publish_date = publish_date;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}


