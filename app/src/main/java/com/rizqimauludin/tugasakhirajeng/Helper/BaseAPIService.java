package com.rizqimauludin.tugasakhirajeng.Helper;

import com.rizqimauludin.tugasakhirajeng.Model.Essay.EssayResponse;
import com.rizqimauludin.tugasakhirajeng.Model.Login.LoginResponse;
import com.rizqimauludin.tugasakhirajeng.Model.Register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseAPIService {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> getLoginResponse(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> getRegisterResponse(
            @Field("name") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("no_hp") String no_hp
    );

    @GET("soal-essay")
    Call<EssayResponse> getEssay();
}
