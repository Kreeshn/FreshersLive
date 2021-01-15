package com.example.fresherslivecompany.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchCompDetailsResponse {
    @SerializedName("comp")
    List<UserComp> CompList;
    String error;

    public FetchCompDetailsResponse(List<UserComp> compList, String error) {
        CompList = compList;
        this.error = error;
    }

    public List<UserComp> getCompList() {
        return CompList;
    }

    public void setCompList(List<UserComp> compList) {
        CompList = compList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
