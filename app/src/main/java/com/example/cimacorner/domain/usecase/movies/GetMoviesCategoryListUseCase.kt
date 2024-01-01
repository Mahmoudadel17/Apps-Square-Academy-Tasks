package com.example.cimacorner.domain.usecase.movies

import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetMoviesCategoryListUseCase @Inject constructor(private val repo : MoviesRepository)  {

    suspend fun getMoviesCategoryList(categoryId:Int) : StateFlow<List<Movie>> {
        return repo.getMoviesCategoryList(categoryId)
    }
}