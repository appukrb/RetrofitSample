package com.appukrb.retrofitsample;

import retrofit.Call;
import retrofit.http.GET;

public interface RetrofitObjectAPI {

    @GET("api/RetrofitAndroidObjectResponse")
    Call<Student> getStudentDetails();
}
