package com.example.cimacorner.data.remote

import com.example.cimacorner.data.remote.dto.CategoriesResponse
import com.example.cimacorner.data.remote.dto.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("genre/movie/list")
    suspend fun getMoviesCategories(@Query("api_key") ApiKey: String): Response<CategoriesResponse>

    @GET("trending/all/week")
    suspend fun getAllMoviesList(@Query("api_key") ApiKey: String): Response<MoviesResponse>

    @GET("discover/movie")
    suspend fun getMoviesCategoryList(@Query("api_key") ApiKey: String,@Query ("with_genres") categoryId:Int): Response<MoviesResponse>



    @GET("search/movie")
    suspend fun getSearchedItem(@Query("api_key") ApiKey: String, @Query("query") SearchedItem : String) : Response<MoviesResponse>


}