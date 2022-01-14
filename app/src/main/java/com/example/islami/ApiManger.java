package com.example.islami;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManger {
   private static Retrofit retrofit;
   private static Retrofit getInstance(){
       if(retrofit==null){
           retrofit = new Retrofit.Builder()
                   .baseUrl("http://api.mp3quran.net/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit;
   }
public  static webservices getApis(){
       return getInstance().create(webservices.class);
}

}
