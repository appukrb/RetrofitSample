package com.appukrb.retrofitsample;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface RetrofitArrayAPI {

    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Student>> getStudentDetails();
}
