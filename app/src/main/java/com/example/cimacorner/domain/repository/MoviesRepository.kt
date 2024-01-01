package com.example.cimacorner.domain.repository

import com.example.cimacorner.data.remote.dto.Category
import com.example.cimacorner.data.remote.dto.Movie
import kotlinx.coroutines.flow.StateFlow

interface MoviesRepository
{
suspend fun getMovieCategories() : StateFlow<List<Category>>
suspend fun getAllMoviesList() : StateFlow<List<Movie>>
suspend fun getMoviesCategoryList(categoryId:Int) : StateFlow<List<Movie>>

}