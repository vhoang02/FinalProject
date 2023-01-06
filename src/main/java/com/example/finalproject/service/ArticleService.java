package com.example.finalproject.service;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class ArticleService {
    public static List<Articles> findAll() {
        String sql = "select * from articles";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Articles.class);
        }
    }

    public static Articles get(int id) {
        String sql = "select * from articles where articles_id = :articles_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(sql)
                    .addParameter("articles_id", id)
                    .executeAndFetch(Articles.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }

    public static List<Articles> getTop3() {
        final String query = "SELECT * FROM articles WHERE  `status` = 100001 ORDER BY views DESC LIMIT 0,3";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static void UpdateDraft(int article_id) {
        final String query = "Update articles Set status = 100001 WHERE articles_id = :articles_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(query)
                    .addParameter("articles_id", article_id)
                    .executeUpdate();
        }
    }

    public static void DeleteByCatID(int cat_id) {
        final String query = "DELETE FROM articles WHERE categories_id = :categories_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(query)
                    .addParameter("categories_id", cat_id)
                    .executeUpdate();
        }
    }

    public static List<Articles> getByCatID(int cat_id) {
        final String query = "SELECT * FROM articles WHERE categories_id = :categories_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("categories_id", cat_id)
                    .executeAndFetch(Articles.class);
        }
    }

    public static List<Articles> getByTagID(int tagID) {
        final String query = "SELECT articles.* FROM articles INNER JOIN tags_has_articles on articles.articles_id = tags_has_articles.articlesTag_id INNER JOIN tags ON tags_has_articles.tagsArti_id = tags.tag_id WHERE tags.tag_id = :tagg";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("tagg", tagID)
                    .executeAndFetch(Articles.class);
        }
    }
}
