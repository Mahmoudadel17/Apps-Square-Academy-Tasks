package com.example.cimacorner.domain.repository

import com.example.cimacorner.data.remote.dto.Category
import com.example.cimacorner.data.remote.dto.Movie
import kotlinx.coroutines.flow.StateFlow

interface MoviesRepository
{
suspend fun getMovieCategories() : StateFlow<List<Category>>
suspend fun getMoviesCategoryList(id : Int) : StateFlow<List<Movie>>

}