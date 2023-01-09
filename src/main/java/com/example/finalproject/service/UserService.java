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

    public static void Delete(int id) {
        String sql = "DELETE FROM users WHERE user_id = :user_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(sql)
                    .addParameter("user_id", id)
                    .executeUpdate();
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
                    .addParameter("expiration", c.getExpiration())
                    .addParameter("role", c.getRole())
                    .addParameter("second_name", c.getSecond_name())
                    .addParameter("dob", c.getDob())
                    .addParameter("email", c.getEmail())
                    .executeUpdate();
        }
    }

    public static void Update(User c){
        String insertSql = "UPDATE users SET password = :password, name = :name, expiration = :expiration, role = :role, second_name = :second_name, email = :email WHERE user_id = :user_id;";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("password", c.getPassword())
                    .addParameter("name", c.getName())
                    .addParameter("expiration", c.getExpiration())
                    .addParameter("role", c.getRole())
                    .addParameter("second_name", c.getSecond_name())
                    .addParameter("email", c.getEmail())
                    .addParameter("user_id", c.getUser_id())
                    .executeUpdate();
        }
    }
    public static User getByUName(String Uname) {
        String sql = "SELECT* FROM users WHERE username = :username";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(sql)
                    .addParameter("username", Uname)
                    .executeAndFetch(User.class);

            if (list.size() == 0)
                return null;

            return list.get(0);
        }
    }
    public static void get7DayPre(int uId){
        String insertSql = "UPDATE users SET expiration = 7 WHERE user_id = :user_id;";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("user_id", uId)
                    .executeUpdate();
        }
    }

}
