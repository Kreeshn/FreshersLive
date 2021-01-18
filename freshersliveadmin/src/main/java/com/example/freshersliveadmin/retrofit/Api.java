package com.example.freshersliveadmin.retrofit;

import com.example.freshersliveadmin.model.AdminLoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("adminLogin.php")
    Call<AdminLoginResponse> adminLogin(
            @Field("adEmail") String adEmail,
            @Field("adPass") String adPass
    );
}
