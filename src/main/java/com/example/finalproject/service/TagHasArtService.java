package com.example.finalproject.service;

import com.example.finalproject.beans.Articles;
import com.example.finalproject.beans.TagHasArticles;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class TagHasArtService {
    public static List<TagHasArticles> getAll() {
        String sql = "select * from tags_has_articles";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(TagHasArticles.class);
        }
    }

    public static TagHasArticles get(int id) {
        String sql = "select * from tags_has_articles where tag_articles_id = :tag_articles_id";
        try (Connection con = DbUtils.getConnection()) {
            List<TagHasArticles> list = con.createQuery(sql)
                    .addParameter("tag_articles_id", id)
                    .executeAndFetch(TagHasArticles.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
    public static List<TagHasArticles> getByEditor(int eId) {
        final String query = "SELECT tags_has_articles.* FROM tags_has_articles INNER JOIN articles ON tags_has_articles.articlesTag_id = articles.articles_id INNER JOIN categories ON articles.categories_id = categories.cat_id WHERE parent_id =:parent_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("parent_id", eId)
                    .executeAndFetch(TagHasArticles.class);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM tags_has_articles WHERE tag_articles_id = :tag_articles_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("tag_articles_id", id)
                    .executeUpdate();
        }
    }
    public static void addTagInArt(TagHasArticles tagsArt) {
        final String query = "INSERT INTO tags_has_articles(tagsArti_id, articlesTag_id) VALUES (:tagsArti_id,:articlesTag_id)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(query)
                    .addParameter("tagsArti_id", tagsArt.getTagsArti_id())
                    .addParameter("articlesTag_id", tagsArt.getArticlesTag_id())
                    .executeUpdate();

        }
    }

}
