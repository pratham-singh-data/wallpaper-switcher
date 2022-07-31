package com.example.wallpaperswitcher;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    public static Retrofit retrofit = null;
    public static final String APIKey = ApiKey.apiKey;

    public static ApiInterface getApiInterface(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit.create(ApiInterface.class);
    }
}
