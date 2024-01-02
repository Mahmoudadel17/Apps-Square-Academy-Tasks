package com.example.cimacorner.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.domain.usecase.search.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchUseCase:SearchUseCase)
    :ViewModel() {

    private val _searchedItems  = MutableStateFlow(emptyList<Movie>())
    val searchedItems : StateFlow<List<Movie>> = _searchedItems


    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery


    fun onChangeSearchQuery(newQuery:String){
        _searchQuery.value = newQuery
        search(newQuery)
    }

    fun onIconSearchClick(){
        search(_searchQuery.value)
    }

    private fun search(newQuery:String){
        viewModelScope.launch(Dispatchers.IO){

            searchUseCase.getSearchedItem(newQuery).collect{
                _searchedItems.value = it
            }
        }
    }



}