package com.example.fresherslivecompany.retrofitutil;

import com.example.fresherslivecompany.model.CompRegResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
}
