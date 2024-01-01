package com.example.cimacorner.domain.repository

import com.example.cimacorner.data.remote.dto.Movie
import kotlinx.coroutines.flow.StateFlow

interface SearchRepository {
    suspend fun getSearchedItem(item : String) : StateFlow<List<Movie>>

}