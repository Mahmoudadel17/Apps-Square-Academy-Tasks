package com.example.cimacorner.data.repository

import com.example.cimacorner.data.remote.ApiService
import com.example.cimacorner.data.remote.dto.Category
import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val api : ApiService, private val apiKey : String ) :
    MoviesRepository {
    override suspend fun getMovieCategories() : StateFlow<List<Category>>{

        val categoriesList = MutableStateFlow(emptyList<Category>())

        val response = api.getMoviesCategories(apiKey)

        if (response.isSuccessful){
            val responseBody = response.body()?.categoriesList
            categoriesList.value = responseBody !!
        }
        return categoriesList
    }



    override suspend fun getAllMoviesList() : StateFlow<List<Movie>>{
        val categoriesList = MutableStateFlow(emptyList<Movie>())
        val response = api.getAllMoviesList(apiKey)
        if (response.isSuccessful){
            val responseBody = response.body()?.movies
            categoriesList.value = responseBody !!
        }
        return categoriesList
    }

    override suspend fun getMoviesCategoryList(categoryId: Int): StateFlow<List<Movie>> {
        TODO("Not yet implemented")
    }

}