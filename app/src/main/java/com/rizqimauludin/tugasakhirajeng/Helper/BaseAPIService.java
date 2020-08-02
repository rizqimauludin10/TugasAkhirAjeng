package com.rizqimauludin.tugasakhirajeng.Helper;

import com.rizqimauludin.tugasakhirajeng.Model.Essay.EssayResponse;
import com.rizqimauludin.tugasakhirajeng.Model.HasilPilgan.HasilPilganResponse;
import com.rizqimauludin.tugasakhirajeng.Model.Latihan.LatihanResponse;
import com.rizqimauludin.tugasakhirajeng.Model.Login.LoginResponse;
import com.rizqimauludin.tugasakhirajeng.Model.Pilgan.PilganResponse;
import com.rizqimauludin.tugasakhirajeng.Model.Register.RegisterResponse;
import com.rizqimauludin.tugasakhirajeng.Model.UpdateProfile.UpdateProfileResponse;
import com.rizqimauludin.tugasakhirajeng.Model.User.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("soal-latihan")
    Call<LatihanResponse> getLatihan();

    @GET("data-user/{id}")
    Call<UserResponse> getUser(
            @Path("id") String id
    );

    @POST("hasil-pilgan/{id}")
    Call<HasilPilganResponse> getHasilPilgan(
            @Path("id") String id,
            @Field("nilai") String nilai
    );


    @FormUrlEncoded
    @POST("profil/update")
    Call<UpdateProfileResponse> getUpdateProfile(
            @Field("id") String id,
            @Field("name") String name,
            @Field("no_hp") String no_hp,
            @Field("nis") String nis,
            @Field("jk") String jk,
            @Field("tempat_lahir") String tempat_lahir,
            @Field("tanggal_lahir") String tanggal_lahir
    );

    @GET("soal-pilgan")
    Call<PilganResponse> getPilganResponse();

}
