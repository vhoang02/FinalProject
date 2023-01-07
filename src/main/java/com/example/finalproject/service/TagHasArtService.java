package com.example.finalproject.service;

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


}
