package com.example.freshersliveadmin.model;

public class Comp {
    private int co_id;
    private String co_name;
    private String co_email;

    public Comp(int co_id, String co_name, String co_email) {
        this.co_id = co_id;
        this.co_name = co_name;
        this.co_email = co_email;
    }

    public int getCo_id() {
        return co_id;
    }

    public String getCo_name() {
        return co_name;
    }

    public String getCo_email() {
        return co_email;
    }
}
