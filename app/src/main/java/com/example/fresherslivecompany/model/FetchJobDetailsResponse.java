package com.example.fresherslivecompany.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchJobDetailsResponse {
    @SerializedName("comp")
    List<UserComp> compList;
    String error;

    public FetchJobDetailsResponse(List<UserComp> compList, String error) {
        this.compList = compList;
        this.error = error;
    }

    public List<UserComp> getCompList() {
        return compList;
    }

    public void setCompList(List<UserComp> compList) {
        this.compList = compList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
