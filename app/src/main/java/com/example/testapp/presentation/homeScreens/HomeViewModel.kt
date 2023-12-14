package com.example.testapp.presentation.homeScreens

import android.net.ConnectivityManager
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.remote.dto.City
import com.example.testapp.domain.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repo:ApiRepository,private val connectivityManager: ConnectivityManager): ViewModel(){

    private val _cities:MutableStateFlow<List<City>> = MutableStateFlow(emptyList())
    val cities:StateFlow<List<City>> = _cities.asStateFlow()

    private var _state by mutableStateOf( true )

    val state: State<Boolean>
        get() =  derivedStateOf{_state}

    init{
        getAllCities()
    }

     private fun getAllCities(){
         val connectionCheck = checkNetworkAvailability()
         if (connectionCheck){
             _state = true
             viewModelScope.launch (Dispatchers.IO){
                 val newCites = repo.getAllCities()
                 _cities.value = newCites
             }
         }else{
             _state = false
         }

    }

    fun getCityById(id:Int):City?{
        return _cities.value.find { it.id == id}
    }

    fun refresh(){
        if (_cities.value.isEmpty()){
            getAllCities()   
        }
    }
    private fun checkNetworkAvailability() : Boolean {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
