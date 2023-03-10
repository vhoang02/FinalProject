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

    public static List<Articles> getTop3InWeek() {
        final String query = "SELECT * FROM articles WHERE publish_date  >=  DATE_SUB(CURRENT_DATE(), INTERVAL 10080 MINUTE) and status= 100001 ORDER BY views DESC LIMIT 0,3\n";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static List<Articles> getTop10() {
        final String query = "SELECT * FROM articles WHERE status= 100001 ORDER BY views DESC LIMIT 0,10\n";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static List<Articles> getTop10new() {
        final String query = "SELECT * FROM articles WHERE status= 100001 ORDER BY articles_id DESC LIMIT 0,10\n";
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


    public static int countByWid(int wId) {
        String query = "SELECT * FROM articles WHERE writer_id = :writer_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("writer_id", wId)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }

    public static int countDrafPubByWid(int wId, int check) {
        String query = "SELECT * FROM articles WHERE writer_id = :writer_id AND status = :status";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("writer_id", wId)
                    .addParameter("status", check)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }
    public  static  void addNews(Articles a){
        final String query = "INSERT INTO articles(title, publish_date, views, abstracts, content, categories_id, premium, writer_id, status) VALUES (:title,NOW(),:views,:abstracts,:content,:categories_id,:premium,:writer_id,:status)";
        try(Connection con  = DbUtils.getConnection())
        {
            con.createQuery(query)
                    .addParameter("title",a.getTitle())
                    .addParameter("views",a.getViews())
                    .addParameter("abstracts", a.getAbstracts())
                    .addParameter("content",a.getContent())
                    .addParameter("categories_id",a.getCategories_id())
                    .addParameter("premium",a.isPremium())
                    .addParameter("writer_id",a.getWriter_id())
                    .addParameter("status",a.getStatus())
                    .executeUpdate();
        }
    }

    public static Articles findArtNew(){
        final String query = "SELECT max(articles_id) as articles_id FROM articles " ;
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0){
                return null;
            }
            return list.get(0);
        }
    }

}
