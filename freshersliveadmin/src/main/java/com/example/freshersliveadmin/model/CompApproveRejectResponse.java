package com.example.freshersliveadmin.model;

public class CompApproveRejectResponse {
    private String error;
    private String message;

    public CompApproveRejectResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
