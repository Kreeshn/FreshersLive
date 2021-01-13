package com.example.fresherslivecompany.model;

public class CompLoginResponse {
    private UserComp userComp;
    private String error;
    private String message;

    public CompLoginResponse(UserComp userComp, String error, String message) {
        this.userComp = userComp;
        this.error = error;
        this.message = message;
    }

    public UserComp getUserComp() {
        return userComp;
    }

    public void setUserComp(UserComp userComp) {
        this.userComp = userComp;
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
