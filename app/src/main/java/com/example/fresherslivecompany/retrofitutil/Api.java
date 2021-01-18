package com.example.fresherslivecompany.retrofitutil;

import com.example.fresherslivecompany.model.CompLoginResponse;
import com.example.fresherslivecompany.model.CompRegResponse;
import com.example.fresherslivecompany.model.FetchJobDetailsResponse;
import com.example.fresherslivecompany.model.FetchOneJobDetailsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("compReg.php")
    Call<CompRegResponse> CompRegistration(
            @Field("cname") String cname,
            @Field("cdec") String cdec,
            @Field("cemail") String cemail,
            @Field("cpassword") String cpassword,
            @Field("ccontact") String ccontact
    );

    @FormUrlEncoded
    @POST("compLogin.php")
    Call<CompLoginResponse> CompLogin(
            @Field("cemail") String cemail,
            @Field("cpassword") String cpassword
    );

    @GET("fetchCompDetails.php")
    Call<FetchJobDetailsResponse> CompDetails();

    @GET("fetchJobDetails.php")
    Call<FetchJobDetailsResponse> JObDetails();

    @FormUrlEncoded
    @POST("fetchOneJob.php")
    Call<FetchOneJobDetailsResponse> fetchJobAllDetails(@Field("job_id") int job_id);

    @FormUrlEncoded
    @POST("createJob.php")
    Call<FetchOneJobDetailsResponse> createJob(
            @Field("co_id") int co_id,
            @Field("profile") String profile,
            @Field("parttime") String parttime,
            @Field("work_type") String work_type,
            @Field("opening") String opening,
            @Field("start_date") String start_date,
            @Field("duration") String duration,
            @Field("respo") String respo,
            @Field("sallaty_type") String sallaty_type,
            @Field("skill_required") String skill_required,
            @Field("ass1") String ass1,
            @Field("ass2") String ass2);
}
