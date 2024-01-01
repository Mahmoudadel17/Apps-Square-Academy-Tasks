package com.example.cimacorner.domain.usecase.movies


import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetMoviesListUseCase  @Inject constructor(private val repo : MoviesRepository)  {

    suspend fun getAllMoviesList() : StateFlow<List<Movie>> {
        return repo.getAllMoviesList()
    }
}