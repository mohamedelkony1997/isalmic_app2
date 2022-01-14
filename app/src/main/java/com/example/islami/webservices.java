package com.example.islami;

import okhttp3.Cache;
import retrofit2.Call;
import retrofit2.http.GET;

public interface webservices {
    @GET("radios/radio_arabic.json")
    Call<RadioChannelResponse> getradiochannel();
}
