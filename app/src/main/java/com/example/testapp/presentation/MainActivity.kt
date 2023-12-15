package com.example.testapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.testapp.presentation.homeScreens.HomeViewModel
import com.example.testapp.presentation.mainScreens.IntroViewModel
import com.example.testapp.presentation.mainScreens.auth.login.LoginViewModel
import com.example.testapp.presentation.mainScreens.auth.signUp.SignUpViewModel
import com.example.testapp.presentation.navigation.AppNavigation
import com.example.testapp.ui.theme.TestappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val introViewModel by viewModels<IntroViewModel>()
    private val signUpViewModel by viewModels<SignUpViewModel>()
    private val loginViewModel by viewModels<LoginViewModel>()
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            TestappTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation(
                        introViewModel,
                        signUpViewModel,
                        loginViewModel,
                        homeViewModel
                    )
                }
            }
        }
    }
}


