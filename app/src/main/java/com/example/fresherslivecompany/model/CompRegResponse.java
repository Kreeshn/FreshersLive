package com.example.fresherslivecompany.model;

import com.google.gson.annotations.SerializedName;

public class CompRegResponse {


    private String error;

    private String message;

    public CompRegResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
