package com.example.testapp.data.repository

import com.example.testapp.data.remote.ApiServices
import com.example.testapp.data.remote.dto.City
import com.example.testapp.domain.ApiRepository
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val api : ApiServices): ApiRepository {
    override suspend fun getAllCities(): List<City> {
        val response = api.getAllCities()

        if (response.isSuccessful){
            val responseBody = response.body()
            responseBody?.let { return it }

        }
        return emptyList()
    }
}