package com.appukrb.retrofitsample;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface Api {

    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Student>> getStudentDetails();


    @GET("api/RetrofitAndroidObjectResponse")
    Call<Student> getStudentDetail();
}
