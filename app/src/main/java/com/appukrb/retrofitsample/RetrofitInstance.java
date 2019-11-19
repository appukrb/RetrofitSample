package com.appukrb.retrofitsample;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetrofitInstance {

    private static final String BASE_URL = "https://androidtutorialpoint.com/";
    private static Retrofit retrofit = null;

    public static Api getApiService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }
}
