package com.example.cimacorner.domain.usecase.movies


import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetMoviesCategoriesListUseCase  @Inject constructor(private val repo : MoviesRepository)  {

    suspend fun getMoviesCategoriesList(id : Int) : StateFlow<List<Movie>> {
        return repo.getMoviesCategoryList(id)
    }
}