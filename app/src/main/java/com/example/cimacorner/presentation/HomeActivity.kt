package com.example.cimacorner.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.cimacorner.di.App
import com.example.cimacorner.domain.network.ConnectivityObserver
import com.example.cimacorner.domain.network.NetworkConnectivityObserver
import com.example.cimacorner.presentation.Home.HomeScreenViewModel
import com.example.cimacorner.presentation.navigation.AppNavigation
import com.example.cimacorner.ui.theme.BackgroundColor
import com.example.cimacorner.ui.theme.CimaCornerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val homeScreenViewModel by viewModels<HomeScreenViewModel>()

    private lateinit var connectivityObserver: ConnectivityObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        setContent {
            CimaCornerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor
                ) {
                   AppNavigation(homeScreenViewModel)

                    // handel on internet available load list
                    val status by connectivityObserver.observe().collectAsState(
                        initial = ConnectivityObserver.Status.Unavailable
                    )
                    if (status ==  ConnectivityObserver.Status.Available){
                        homeScreenViewModel.reInit()
                    }
                }
            }
        }
    }
}

