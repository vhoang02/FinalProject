package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String name;
    private int role;
    private String second_name;
    private LocalDateTime dob;
    private String email;
    public User() {
    }

    public User(int user_id, String username, String password, String name, int role, String second_name, LocalDateTime dob, String email) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.second_name = second_name;
        this.dob = dob;
        this.email = email;
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

}
