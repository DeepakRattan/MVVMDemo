package com.example.deepakrattan.mvvmdemo.network;


import com.example.deepakrattan.mvvmdemo.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("/api/unknown")
    Call<MovieResponse> getMovies();
}
