package com.example.testapp.data.remote

import com.example.testapp.data.remote.dto.City
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("cities.json")
    suspend fun getAllCities():Response<List<City>>

}