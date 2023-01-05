package com.example.finalproject.service;

import com.example.finalproject.beans.Tag;
import com.example.finalproject.utils.DbUtils;
import com.ute.newsproject.beans.Tag;
import com.ute.newsproject.utils.DbUtils;
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

    public static void add(Tag c) {
        String insertSql = "insert into tags(value) values (:value)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("value", c.getVal())
                    .executeUpdate();
        }
    }

    public static void update(Tag c) {
        String sql = "update tags set value = :value where tag_id = :tag_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("tag_id", c.getTagID())
                    .addParameter("value", c.getVal())
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
}
