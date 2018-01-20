package com.hussainmukadam.androidexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonElement;
import com.hussainmukadam.androidexamples.network.ApiClient;
import com.hussainmukadam.androidexamples.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeNetworkCall();
    }

    private void makeNetworkCall(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<JsonElement> call = apiInterface.sendUserDetails(1,1);

        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                Log.d(TAG, "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {

            }
        });
    }
}
