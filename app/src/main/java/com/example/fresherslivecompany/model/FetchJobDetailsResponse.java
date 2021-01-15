package com.example.fresherslivecompany.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchJobDetailsResponse {
    @SerializedName("jobs")
    List<JobComp> jobCompList;
    String result_code;

    public FetchJobDetailsResponse(List<JobComp> jobCompList, String result_code) {
        this.jobCompList = jobCompList;
        this.result_code = result_code;
    }

    public List<JobComp> getJobCompList() {
        return jobCompList;
    }

    public void setJobCompList(List<JobComp> jobCompList) {
        this.jobCompList = jobCompList;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }
}
