package com.example.fresherslivecompany.model;

public class UserComp {
    private int co_id;
    private String co_name;
    private String co_email;

    public UserComp(int co_id, String co_name, String co_email) {
        this.co_id = co_id;
        this.co_name = co_name;
        this.co_email = co_email;
    }

    public int getCo_id() {
        return co_id;
    }

    public void setCo_id(int co_id) {
        this.co_id = co_id;
    }

    public String getCo_name() {
        return co_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
    }

    public String getCo_email() {
        return co_email;
    }

    public void setCo_email(String co_email) {
        this.co_email = co_email;
    }
}
