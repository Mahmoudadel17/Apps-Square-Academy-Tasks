package com.example.cimacorner.data.repository

import com.example.cimacorner.data.remote.ApiService
import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.domain.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api : ApiService, private val apiKey : String) :
    SearchRepository {
    override suspend fun getSearchedItem(item : String) : StateFlow<List<Movie>> {

        val searchedItem = MutableStateFlow(emptyList<Movie>())

        val response = api.getSearchedItem(apiKey,item)

        if (response.isSuccessful){
            val responseBody = response.body()?.movies
            searchedItem.value = responseBody !!
        }
        return searchedItem
    }

}