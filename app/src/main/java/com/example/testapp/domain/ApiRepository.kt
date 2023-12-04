package com.example.testapp.domain

import com.example.testapp.data.remote.dto.City

interface ApiRepository {
    suspend fun getAllCities():List<City>
}