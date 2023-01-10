package com.example.finalproject.models;

import com.example.finalproject.beans.User;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.time.LocalDate;
import java.util.List;

public class UserModel {

    public static List<User> findAllUser()
    {
        final String query = "select * from users";
        try(Connection con = DbUtils.getConnection()){
            return con.createQuery(query)
                    .executeAndFetch(User.class);
        }
    }


    public static void deleteUser(int user_id)
    {
        final String query = "DELETE FROM users WHERE user_id = :user_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("user_id",user_id)
                    .executeUpdate();

        }
    }

    public static void updateUser(User c) {
        String insertSql = "UPDATE users SET  username = :username, password = :password, name = :name, issue_at = :issue_at, expiration = :expiration, role_id = :role_id, second_name = :second_name, date_of_birth = :date_of_birth, email = :email, otp = :otp, otp_exp = :otp_exp,premium = :premium WHERE user_id = :user_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("user_id",c.getUser_id())
                    .addParameter("username", c.getUsername())
                    .addParameter("password", c.getPassword())
                    .addParameter("name", c.getName())
                    .addParameter("issue_at", c.getIssue_at())
                    .addParameter("expiration", c.getExpiration())
                    .addParameter("role_id", c.getRole())
                    .addParameter("second_name", c.getSecond_name())
                    .addParameter("date_of_birth", c.getDob())
                    .addParameter("email", c.getEmail())
                    .addParameter("otp_exp", c.getOtp_exp())
                    .addParameter("otp", c.getOtp())
                    .addParameter("premium",c.getPremium())
                    .executeUpdate();
        }
    }

    public static void add(User c){
        String insertSql = "insert into web_final.users (username, password, name, issue_at, expiration, role, second_name, dob, email,\n" +
                "                             otp, otp_exp)\n" +
                "values (:username,:password,:name,:issue_at,:expiration,:role,:second_name,:dob,:email,:otp,:otp_exp)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("username", c.getUsername())
                    .addParameter("password", c.getPassword())
                    .addParameter("name", c.getName())
                    .addParameter("issue_at", c.getIssue_at())
                    .addParameter("expiration", c.getExpiration())
                    .addParameter("role", c.getRole())
                    .addParameter("second_name", c.getSecond_name())
                    .addParameter("dob", c.getDob())
                    .addParameter("email", c.getEmail())
                    .addParameter("otp", c.getOtp())
                    .addParameter("otp_exp", c.getOtp())
                    .executeUpdate();
        }
    }


    // Kiểm tra xem Username có bị trùng hay không
    public static boolean checkByUserName(String username) {
        String query = "select * from users where username = :username";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("username", username)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return false;
            }
            return true;
        }
    }

    public static User findByUsername(String username){
        final String query = "select * from users where username = :username";
        try(Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("username", username)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
    }


    //Tìm User theo user_id
    public static User findByUserId(int user_id) {
        final String query = "select * from users where user_id = :user_id";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("user_id", user_id)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return null;
            }
            return list.get(0);
        }
    }

    //Edit thông tin của User
    public static void editUser(int user_id,String username ,String password, String email, LocalDate dob, String second_name) {

        String updateSql = "UPDATE users SET username = :username,password =:password,email= :email,dob=:dob, second_name=:second_name  WHERE user_id= :user_id";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(updateSql)
                    .addParameter("user_id", user_id)
                    .addParameter("username", username)
                    .addParameter("username", password)
                    .addParameter("email", email)
                    .addParameter("date_of_birth", dob)
                    .addParameter("second_name",second_name)
                    .executeUpdate();
        }
    }

    // Kiểm tra tài khoản người dùng có còn hạn hay không
    public static boolean  checkExpiration(int user_id) {
        String query = "SELECT * FROM users WHERE expiration >=  DATEDIFF (CURRENT_DATE(),issue_at) AND user_id = :user_id";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("user_id", user_id)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return false;
            }
            return true;
        }
    }

    //Thêm tài khoản Premium
    public static void editAccountPremium(int user_id,LocalDate issue_at ) {
        String updateSql = "UPDATE users SET issue_at = :issue_at, premium = 1 WHERE user_id= :user_id ";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(updateSql)
                    .addParameter("user_id", user_id)
                    .addParameter("issue_at", issue_at)
                    .executeUpdate();
        }
    }

    //Kiểm tra xem mã Otp có trùng khớp hay không
    public static boolean checkOtp(String otp, String email) {
        String query = "SELECT otp_exp FROM users WHERE otp= :otp AND email= :email";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("otp", otp)
                    .addParameter("email", email)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

}
