package com.example.cimacorner.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cimacorner.presentation.Home.HomeScreenViewModel
import com.example.cimacorner.presentation.navigation.AppNavigation
import com.example.cimacorner.ui.theme.BackgroundColor
import com.example.cimacorner.ui.theme.CimaCornerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val homeScreenViewModel by viewModels<HomeScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CimaCornerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor
                ) {
                   AppNavigation(homeScreenViewModel)
                }
            }
        }
    }
}

