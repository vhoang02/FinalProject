package com.example.finalproject.models;

import com.example.finalproject.beans.User;
import com.example.finalproject.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;

public class UserModel {
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
}
