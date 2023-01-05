package com.example.finalproject.service;

import com.example.finalproject.beans.Commnent;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class CommentService {
    public static List<Commnent> getAll() {
        String sql = "select * from comments";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Commnent.class);
        }
    }

    public static Commnent findById(int id) {
        String sql = "select * from comments where comment_id =  :comment_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Commnent> list = con.createQuery(sql)
                    .addParameter("comment_id", id)
                    .executeAndFetch(Commnent.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
}
