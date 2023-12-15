package com.example.testapp.presentation.mainScreens


import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.testapp.di.TokenManager
import com.example.testapp.presentation.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(private val tokenManager: TokenManager) : ViewModel() {

    fun explore(navController: NavHostController){
        if (tokenManager.getToken() != null) {
            // Token exists, open home screen
            navController.navigate(Screens.Home.route){
                    // want to remove this screen from back stack
                    popUpTo(Screens.Intro.route) {
                        inclusive = true
                    }
                }
        } else {
            // Token is null, open SignUp screen
            navController.navigate(Screens.SignUp.route)
        }

    }

}