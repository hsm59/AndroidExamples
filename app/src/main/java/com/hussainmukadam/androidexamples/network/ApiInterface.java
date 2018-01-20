package com.hussainmukadam.androidexamples.network;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by hussain on 20/01/18.
 */

public interface ApiInterface {
    @Headers("accesstoken: ")
    @FormUrlEncoded
    @POST("Servicev2/getCards")
    Call<JsonElement> sendUserDetails(@Field("userID") int id, @Field("cardType") int cardType);
}
