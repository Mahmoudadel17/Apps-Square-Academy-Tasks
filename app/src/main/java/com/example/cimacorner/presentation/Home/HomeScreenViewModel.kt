package com.example.cimacorner.presentation.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cimacorner.data.allCategory
import com.example.cimacorner.data.remote.dto.*
import com.example.cimacorner.domain.usecase.movies.GetMovieCategoriesUseCase
import com.example.cimacorner.domain.usecase.movies.GetMoviesCategoryListUseCase
import com.example.cimacorner.domain.usecase.movies.GetMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val moviesUseCase:GetMoviesListUseCase,
    private val moviesCategoryListUseCase: GetMoviesCategoryListUseCase,
    private val categoriesUseCase: GetMovieCategoriesUseCase
) : ViewModel() {
    private val _tabList = MutableStateFlow(emptyList<Category>())
    val tabList: StateFlow<List<Category>> = _tabList

    private val _movieList = MutableStateFlow(emptyList<Movie>())
    val movieList: StateFlow<List<Movie>> = _movieList

    private val _movieListFiltered = MutableStateFlow(emptyList<Movie>())
    val movieListFiltered: StateFlow<List<Movie>> = _movieListFiltered

    private val _movieListFilteredReady = MutableStateFlow(false)
    val movieListFilteredReady: StateFlow<Boolean> = _movieListFilteredReady




    init {
        // get all tabs ( movies categories)
        getCategoriesList()

        // get movies using all movies end point
        getAllMovies()
    }



    private fun getCategoriesList(){
        _tabList.value = listOf( allCategory)
        viewModelScope.launch(Dispatchers.IO) {
            categoriesUseCase.getMovieCategories().collect{
                _tabList.value = _tabList.value + it
            }
        }
    }


    private fun getAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            moviesUseCase.getAllMoviesList().collect{
                _movieList.value = it
            }

        }

    }


    private fun getMoviesCategoryList(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            moviesCategoryListUseCase.getMoviesCategoryList(id).collect{
                _movieListFiltered.value = it
                _movieListFilteredReady.value = true
            }
        }
    }

     fun onSelectingTab(category: Category){
        _movieListFilteredReady.value = false
        getMoviesCategoryList(category.id)
    }




}