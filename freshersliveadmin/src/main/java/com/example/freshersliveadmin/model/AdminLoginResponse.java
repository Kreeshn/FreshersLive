package com.example.freshersliveadmin.model;

public class AdminLoginResponse {
    private int aid;
    private String a_email;
    private String message;
    private String error;

    public AdminLoginResponse(int aid, String a_email, String message, String error) {
        this.aid = aid;
        this.a_email = a_email;
        this.message = message;
        this.error = error;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getA_email() {
        return a_email;
    }

    public void setA_email(String a_email) {
        this.a_email = a_email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
