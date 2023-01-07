package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class Commnent {
    private int comment_articles_id, comment_users_id, comment_id;
    private  String comment;
    private LocalDateTime comment_date;

    public Commnent() {
    }

    public Commnent(int comment_articles_id, int comment_users_id, int comment_id, String comment, LocalDateTime comment_date) {
        this.comment_articles_id = comment_articles_id;
        this.comment_users_id = comment_users_id;
        this.comment_id = comment_id;
        this.comment = comment;
        this.comment_date = comment_date;
    }

    public int getComment_articles_id() {
        return comment_articles_id;
    }

    public void setComment_articles_id(int comment_articles_id) {
        this.comment_articles_id = comment_articles_id;
    }

    public int getComment_users_id() {
        return comment_users_id;
    }

    public void setComment_users_id(int comment_users_id) {
        this.comment_users_id = comment_users_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getComment_date() {
        return comment_date;
    }

    public void setComment_date(LocalDateTime comment_date) {
        this.comment_date = comment_date;
    }
}
