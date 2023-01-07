package com.example.finalproject.service;

import com.example.finalproject.beans.User;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class UserService {
    public static List<User> getAll() {
        String sql = "select * from users";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    public static List<User> getEditor() {
        String sql = "SELECT* FROM users WHERE role = 1";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    public static User get(int id) {
        String sql = "select * from users where user_id = :user_id";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(sql)
                    .addParameter("user_id", id)
                    .executeAndFetch(User.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }

    public static User findByUsername(String uName) {
        final String query = "select * from users where uName = :uName";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("uName", uName)
                    .executeAndFetch(User.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }
    public static User getUMaCat(int idCat) {
        String sql = "SELECT users.* FROM categories INNER JOIN users ON categories.parent_id = users.user_id WHERE cat_id = :cat_id";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(sql)
                    .addParameter("cat_id", idCat)
                    .executeAndFetch(User.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
}
