package com.example.wallpaperswitcher;

import static com.example.wallpaperswitcher.ApiUtilities.APIKey;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    String BaseUrl = "https://api.pexels.com/v1/";

    @Headers("Authorization: "+APIKey)
    @GET("curated")
    Call<ResponseModel> getImages(
            @Query("page") int page,
            @Query("per_page") int per_page
    );

    @Headers("Authorization: "+APIKey)
    @GET("search")
    Call<ResponseModel> getImages(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int per_page
    );
}