package com.example.cimacorner.domain.usecase.movies

import com.example.cimacorner.data.remote.dto.Category
import com.example.cimacorner.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetMovieCategoriesUseCase @Inject constructor(private val repo : MoviesRepository)  {

    suspend fun getMovieCategories() : StateFlow<List<Category>> {
        return repo.getMovieCategories()
    }
}