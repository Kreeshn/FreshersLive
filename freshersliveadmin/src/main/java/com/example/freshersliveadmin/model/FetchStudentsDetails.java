package com.example.freshersliveadmin.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchStudentsDetails {
    @SerializedName("student")
    List<Student> StdList;
    String error;

    public FetchStudentsDetails(List<Student> stdList, String error) {
        StdList = stdList;
        this.error = error;
    }

    public List<Student> getStdList() {
        return StdList;
    }

    public String getError() {
        return error;
    }
}
