package com.example.finalproject.models;

import com.example.finalproject.beans.Tag;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class TagModel {

    public static List<Tag> findAllTag() {
        final String query = "SELECT * FROM tags";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Tag.class);
        }
    }

    // Kiểm tra xem Tag Id có trùng hay không
    public static boolean checkTagById(int tag_id) {
        String query = "select * from tags where tag_id = :tag_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .addParameter("tag_id",tag_id)
                    .executeAndFetch(Tag.class);
            if (list.size() == 0) {
                return false;
            }
            return true;
        }
    }


    // tìm kiếm theo Tag ID
    public static Tag findTagById(int tag_id) {
        final String query = "SELECT * FROM tags WHERE tag_id = :tag_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .addParameter("tag_id", tag_id)
                    .executeAndFetch(Tag.class);
            if (list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
    }

    //
    public static void addTag(Tag tags)
    {
        final String query = "INSERT INTO tags (value) VALUES (:value)";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("value", tags.getValue())
                    .executeUpdate();

        }
    }

    public static void deleteTag(int tag_id)
    {
        final String query = "DELETE FROM tags WHERE tag_id = :tag_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("tag_id",tag_id)
                    .executeUpdate();

        }
    }
    public static void updateTage(Tag tag)
    {
        final String query = "UPDATE tags SET  value = :value WHERE tag_id = :tag_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("tag_id",tag.getTag_id())
                    .addParameter("value", tag.getValue())
                    .executeUpdate();

        }
    }
}
