package com.example.cimacorner.presentation.Home

import android.net.ConnectivityManager
import android.util.Log
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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val moviesUseCase:GetMoviesListUseCase,
    private val moviesCategoryListUseCase: GetMoviesCategoryListUseCase,
    private val categoriesUseCase: GetMovieCategoriesUseCase,
    private val connectivityManager: ConnectivityManager
) : ViewModel() {
    private val _tabList = MutableStateFlow(emptyList<Category>())
    val tabList: StateFlow<List<Category>> = _tabList

    private val _movieList = MutableStateFlow(emptyList<Movie>())
    val movieList: StateFlow<List<Movie>> = _movieList

    private val _movieListFiltered = MutableStateFlow(emptyList<Movie>())
    val movieListFiltered: StateFlow<List<Movie>> = _movieListFiltered

    private val _internetAvailable = MutableStateFlow(false)
    val internetAvailable: StateFlow<Boolean> = _internetAvailable




    init {

        if (checkNetworkAvailability()){
            _internetAvailable.value  = true
            // get all tabs ( movies categories)
            getCategoriesList()

            // get movies using all movies end point
            getAllMovies()
        }

    }

    fun reInit(){
        _internetAvailable.value  = true
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

            }
        }
    }

     fun onSelectingTab(category: Category){
         if (checkNetworkAvailability()){
             _internetAvailable.value = true
             getMoviesCategoryList(category.id)
         }else{
             viewModelScope.launch {
                 delay(1000)
                 _internetAvailable.value = false
             }

         }

    }

     private fun checkNetworkAvailability() : Boolean {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }


}