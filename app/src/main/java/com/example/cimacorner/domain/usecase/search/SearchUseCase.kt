package com.example.cimacorner.domain.usecase.search

import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.domain.repository.SearchRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val repo : SearchRepository){

    suspend fun getSearchedItem(item : String) : StateFlow<List<Movie>> {
        return repo.getSearchedItem(item)
    }
}