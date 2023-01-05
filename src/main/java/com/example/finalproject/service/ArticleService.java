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


}
