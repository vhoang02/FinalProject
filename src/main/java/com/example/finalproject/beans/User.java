package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime issue_at;
    private int expiration;
    private int role;
    private String second_name;
    private LocalDateTime dob;
    private String email;
    private String otp;
    private LocalDateTime otp_exp;
    private int premium;
    public User(){

    }
    public User(int user_id, String username, String password, String name, LocalDateTime issue_at, int expiration, int role, String second_name, LocalDateTime dob, String email, String otp, LocalDateTime otp_exp, int premium) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.issue_at = issue_at;
        this.expiration = expiration;
        this.role = role;
        this.second_name = second_name;
        this.dob = dob;
        this.email = email;
        this.otp = otp;
        this.otp_exp = otp_exp;
        this.premium = premium;
    }

    public User(int i, String username, String bcryptHashString, String name, LocalDateTime issue_at, int expiration, int role, String second_name, LocalDateTime dob, String email, String otp, LocalDateTime otp_exp) {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getIssue_at() {
        return issue_at;
    }

    public void setIssue_at(LocalDateTime issue_at) {
        this.issue_at = issue_at;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getOtp_exp() {
        return otp_exp;
    }


    public int getPremium() {
        return premium;
    }
}