package com.example.finalproject.service;

import com.example.finalproject.beans.Category;
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

    public static int countUser( ) {
        String query = "SELECT * FROM users";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .executeAndFetch(User.class);
            return list.size();
        }
    }
    public static int countAdmin( ) {
        String query = "SELECT * FROM users WHERE role = 0";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .executeAndFetch(User.class);
            return list.size();
        }
    }

    public static int countEditor( ) {
        String query = "SELECT * FROM users WHERE role = 1";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .executeAndFetch(User.class);
            return list.size();
        }
    }

    public static int countWriter( ) {
        String query = "SELECT * FROM users WHERE role = 2";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .executeAndFetch(User.class);
            return list.size();
        }
    }

    public static int countReader( ) {
        String query = "SELECT * FROM users WHERE role = 3";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .executeAndFetch(User.class);
            return list.size();
        }
    }

    public static void add(User c){
        String insertSql = "insert into web_final.users (username, password, name,issue_at,expiration , role, second_name, dob, email) " +
                "values (:username,:password,:name,NOW(),:expiration,:role,:second_name,:dob,:email);";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("username", c.getUsername())
                    .addParameter("password", c.getPassword())
                    .addParameter("name", c.getName())
                    .addParameter("role", c.getRole())
                    .addParameter("second_name", c.getSecond_name())
                    .addParameter("dob", c.getDob())
                    .addParameter("email", c.getEmail())
                    .executeUpdate();
        }
    }



}
