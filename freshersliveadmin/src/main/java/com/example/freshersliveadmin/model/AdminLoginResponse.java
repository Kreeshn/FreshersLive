package com.example.freshersliveadmin.model;

public class AdminLoginResponse {
    public int aid;
    public String a_name;
    public String a_email;
    public String error;
    public String message;

    public AdminLoginResponse(int aid, String a_name, String a_email, String error, String message) {
        this.aid = aid;
        this.a_name = a_name;
        this.a_email = a_email;
        this.error = error;
        this.message = message;
    }

    public int getAid() {
        return aid;
    }

    public String getA_name() {
        return a_name;
    }

    public String getA_email() {
        return a_email;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
