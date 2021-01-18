package com.example.freshersliveadmin.retrofit;

import com.example.freshersliveadmin.model.AdminLoginResponse;
import com.example.freshersliveadmin.model.CompApproveRejectResponse;
import com.example.freshersliveadmin.model.FetchCompDetailsResponse;
import com.example.freshersliveadmin.model.FetchStudentsDetails;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("adminLogin.php")
    Call<AdminLoginResponse> adminLogin(
            @Field("adEmail") String adEmail,
            @Field("adPass") String adPass
    );

    @GET("fetchCompAllDetailsPendding.php")
    Call<FetchCompDetailsResponse> fetchCompDetails();

    @GET("fetchCompAllDetailsApproved.php")
    Call<FetchCompDetailsResponse> fetchCompDetailsApproved();

    @GET("fetchCompAllDetailsRejected.php")
    Call<FetchCompDetailsResponse> fetchCompDetailsRejected();

    @FormUrlEncoded
    @POST("AcceptRejectCompReq.php")
    Call<CompApproveRejectResponse> compApproveReject(
            @Field("cid") int cid,
            @Field("status") int status
    );

    @GET("fetchStudentDetails.php")
    Call<FetchStudentsDetails> fetchStudentsDetails();

    @GET("fetchApprovedStudentsDetails.php")
    Call<FetchStudentsDetails> fetchApprovedStudentsDetails();

    @GET("fetchRejectedStudentsDetails.php")
    Call<FetchStudentsDetails> fetchRejectedStudentsDetails();

}
