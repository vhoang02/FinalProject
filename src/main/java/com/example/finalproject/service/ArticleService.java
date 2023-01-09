package com.example.finalproject.service;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.beans.Category;
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
// lấy ra tất cả các bài đã được xuất bản
    public static List<Articles> getAllPublic() {
        String sql = "SELECT * FROM articles WHERE status = 100001";
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
        final String query = "UPDATE articles SET `publish_date` = NOW(), `status`=100001 WHERE articles_id = :articles_id";
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

    public static void DeleteByWId(int wId) {
        final String query = "DELETE FROM articles WHERE writer_id = :writer_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(query)
                    .addParameter("writer_id", wId)
                    .executeUpdate();
        }
    }

    public static void Delete(int id) {
        String sql = "DELETE FROM articles WHERE articles_id = :articles_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("articles_id", id)
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

    public static List<Articles> getByEditor(int eId) {
        final String query = "SELECT articles.* FROM articles INNER JOIN categories ON articles.categories_id = categories.cat_id WHERE parent_id =:parent_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("parent_id", eId)
                    .executeAndFetch(Articles.class);
        }
    }

    public static List<Articles> getBywId(int id) {
        final String query = "SELECT * FROM articles WHERE writer_id = :writer_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("writer_id", id)
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

    // lấy ra các bài premium đã được xuất bản
    public static List<Articles> getAllPublicPre() {
        String sql = "SELECT * FROM articles WHERE `status` = 100001 AND premium = 0";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Articles.class);
        }
    }

    public static int countArt( ) {
        String query = "SELECT * FROM articles";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }

    public static int countArtPublish( ) {
        String query = "SELECT * FROM articles WHERE `status` = 100001";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }
    public static int countArtDraft( ) {
        String query = "SELECT * FROM articles WHERE `status` = 100002";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }


    public static int countPubPre( ) {
        String query = "SELECT * FROM articles WHERE `status` = 100001 AND premium = 1  ";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }

    public static int countDraftPre( ) {
        String query = "SELECT * FROM articles WHERE `status` = 100001 AND premium = 1";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }

    public static int countByEID(int eId) {
        String query = "SELECT articles.* FROM articles INNER JOIN categories ON articles.categories_id = categories.cat_id WHERE parent_id =:parent_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("parent_id", eId)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }

    public static int countDraftByEID(int eId) {
        String query = "SELECT articles.* FROM articles INNER JOIN categories ON articles.categories_id = categories.cat_id WHERE parent_id =:parent_id AND status = 100002";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("parent_id", eId)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }

    public static int countPubByEID(int eId) {
        String query = "SELECT articles.* FROM articles INNER JOIN categories ON articles.categories_id = categories.cat_id WHERE parent_id =:parent_id AND status = 100001";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("parent_id", eId)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }

    public static int countPreByeID(int eId) {
        String query = "SELECT articles.* FROM articles INNER JOIN categories ON articles.categories_id = categories.cat_id WHERE parent_id =:parent_id AND premium = 1";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("parent_id", eId)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }






}
