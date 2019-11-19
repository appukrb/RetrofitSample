package com.appukrb.retrofitsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


//Refer https://www.androidtutorialpoint.com/networking/retrofit-android-tutorial/
public class MainActivity extends AppCompatActivity {

    final String url = "https://androidtutorialpoint.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getArrayOfDataAsync();
        getList();
    }

    private void getList() {
        final Api api = RetrofitInstance.getApiService();
        Call<List<Student>> request =  api.getStudentDetails();
        request.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Response<List<Student>> response, Retrofit retrofit) {
                if(response.isSuccess()){
                    Log.d("array size",""+response.body().size());
                    Toast.makeText(MainActivity.this, ""+response.body().size(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    private void getArrayOfDataAsync(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<Student>> call = service.getStudentDetails();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Response<List<Student>> response, Retrofit retrofit) {
                if(response.isSuccess()){
                    Log.d("array size",""+response.body().size());
                    Toast.makeText(MainActivity.this, ""+response.body().size(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
