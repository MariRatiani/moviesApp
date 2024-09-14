package com.example.myapplication.API

import com.example.myapplication.Models.MovieInfo
import com.example.myapplication.Models.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface OMBDApi {
    @GET("?")
    suspend fun getMovieInfo(@Query("i") imdbId: String, @Query("apikey") apiKey: String =  "761342e3"): MovieInfo

    @GET("?")
    suspend fun searchMovies(@Query("s") query: String, @Query("apikey") apiKey: String =  "761342e3"): Response
}
