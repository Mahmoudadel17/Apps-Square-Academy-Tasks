package com.example.testapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testapp.presentation.homeScreens.HomeScreen
import com.example.testapp.presentation.mainScreens.IntroScreen
import com.example.testapp.presentation.mainScreens.auth.signUp.SignUpScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Intro.route){
        composable(route = Screens.Intro.route){
//            IntroScreen(navController = navController)
            HomeScreen()
        }
        composable(route = Screens.SignUp.route){
            SignUpScreen()
        }
        composable(route = Screens.Login.route){

        }
        composable(route = Screens.Home.route){

        }
        composable(route = "${Screens.City.route}/{cityId}",arguments = listOf(
            navArgument("cityId"){type = NavType.IntType}
        )){
            val id = it.arguments?.getInt("cityId")
            id?.let {
                // if id not null go to city screen

            }
        }

        composable(route = Screens.CommingSoon.route){

        }
    }
}