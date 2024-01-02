package com.example.cimacorner.data.repository

import android.util.Log
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
        try {
            val response = api.getMoviesCategories(apiKey)

            if (response.isSuccessful){

                val responseBody = response.body()?.categoriesList
                categoriesList.value = responseBody !!
            }
        }catch (e: Exception) {
            e.printStackTrace()
            return categoriesList
        }


        return categoriesList
    }



    override suspend fun getAllMoviesList() : StateFlow<List<Movie>>{
        val allMovies = MutableStateFlow(emptyList<Movie>())

        try {
            val response = api.getAllMoviesList(apiKey)
            if (response.isSuccessful){

                val responseBody = response.body()?.movies
                allMovies.value = responseBody !!
            }
        }catch (e: Exception) {
            e.printStackTrace()
            return allMovies
        }
        return allMovies
    }

    override suspend fun getMoviesCategoryList(categoryId: Int): StateFlow<List<Movie>> {

        val categoryMovies = MutableStateFlow(emptyList<Movie>())
        try {
            val response = api.getMoviesCategoryList(apiKey,categoryId)
            if (response.isSuccessful){
                val responseBody = response.body()?.movies
                categoryMovies.value = responseBody !!
            }
        }catch (e: Exception) {
            e.printStackTrace()
            return categoryMovies
        }

        return categoryMovies
    }

}