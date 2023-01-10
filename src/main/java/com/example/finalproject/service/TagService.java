package com.example.finalproject.service;

import com.example.finalproject.beans.Category;
import com.example.finalproject.beans.Tag;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class TagService {

    public static List<Tag> findAll() {
        final String query = "select * from tags";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Tag.class);
        }
    }

    public static Tag findById(int id) {
        final String query = "select * from tags where tag_id = :tag_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .addParameter("tag_id", id)
                    .executeAndFetch(Tag.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }

    public static List<Tag> findAllByAid(int id) {
        final String query = "SELECT tags.* FROM tags INNER JOIN tags_has_articles ON tags.tag_id = tags_has_articles.tagsArti_id WHERE tags_has_articles.articlesTag_id =:articlesTag_id ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("articlesTag_id", id)
                    .executeAndFetch(Tag.class);
        }
    }

    public static Tag findByval(String val) {
        final String query = "select * from tags where value =:value";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .addParameter("value", val)
                    .executeAndFetch(Tag.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }
    public static void add(Tag c) {
        String insertSql = "insert into tags(value) values (:value)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("value", c.getValue())
                    .executeUpdate();
        }
    }

    public static void update(Tag c) {
        String sql = "update tags set value = :value where tag_id = :tag_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("tag_id", c.getTag_id())
                    .addParameter("value", c.getValue())
                    .executeUpdate();
        }
    }

    public static void delete(int id) {
        String sql = "delete from tags where tag_id = :tag_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("tag_id", id)
                    .executeUpdate();
        }
    }
    public static int counTag( ) {
        String query = "SELECT * FROM tags";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .executeAndFetch(Tag.class);
            return list.size();
        }
    }

    public static void addTag(Tag tag)
    {
        final String query = "INSERT INTO tags (value) VALUES (:value)";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("value", tag.getValue())
                    .executeUpdate();

        }
    }
    public static void updateTage(Tag tag)
    {
        final String query = "UPDATE tags SET value = :value WHERE tag_id = :tag_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("tag_id",tag.getTag_id())
                    .addParameter("value", tag.getValue())
                    .executeUpdate();

        }
    }
    public static void deleteTag(int tags_id)
    {
        final String query = "DELETE FROM tags WHERE tag_id =:tag_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("tag_id",tags_id)
                    .executeUpdate();

        }
    }
}
