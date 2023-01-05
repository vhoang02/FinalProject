package com.example.finalproject.beans;

import java.time.LocalDateTime;

public class User {
    private int uID, exp, rol;
    private String uName, pass, name, secName, email, otp;
    private LocalDateTime issue, birth, otpExp;

    public User() {
    }

    public User(int uID, int exp, int rol, String uName, String pass, String name, String secName, String email, String otp, LocalDateTime issue, LocalDateTime birth, LocalDateTime otpExp) {
        this.uID = uID;
        this.exp = exp;
        this.rol = rol;
        this.uName = uName;
        this.pass = pass;
        this.name = name;
        this.secName = secName;
        this.email = email;
        this.otp = otp;
        this.issue = issue;
        this.birth = birth;
        this.otpExp = otpExp;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
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

    public LocalDateTime getIssue() {
        return issue;
    }

    public void setIssue(LocalDateTime issue) {
        this.issue = issue;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public LocalDateTime getOtpExp() {
        return otpExp;
    }

    public void setOtpExp(LocalDateTime otpExp) {
        this.otpExp = otpExp;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID=" + uID +
                ", exp=" + exp +
                ", rol=" + rol +
                ", uName='" + uName + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", secName='" + secName + '\'' +
                ", email='" + email + '\'' +
                ", otp='" + otp + '\'' +
                ", issue=" + issue +
                ", birth=" + birth +
                ", otpExp=" + otpExp +
                '}';
    }
}
