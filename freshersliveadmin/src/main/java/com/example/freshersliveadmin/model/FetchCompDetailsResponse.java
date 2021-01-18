package com.example.freshersliveadmin.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchCompDetailsResponse {
    @SerializedName("comp")
    List<Comp> CompList;
    String error;

    public FetchCompDetailsResponse(List<Comp> compList, String error) {
        CompList = compList;
        this.error = error;
    }

    public List<Comp> getCompList() {
        return CompList;
    }

    public String getError() {
        return error;
    }
}
