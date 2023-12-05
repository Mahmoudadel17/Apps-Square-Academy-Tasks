package com.example.testapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testapp.presentation.homeScreens.CityScreen
import com.example.testapp.presentation.homeScreens.CommingSoon
import com.example.testapp.presentation.homeScreens.HomeScreen
import com.example.testapp.presentation.homeScreens.HomeViewModel
import com.example.testapp.presentation.mainScreens.IntroScreen
import com.example.testapp.presentation.mainScreens.auth.login.LoginScreen
import com.example.testapp.presentation.mainScreens.auth.login.LoginViewModel
import com.example.testapp.presentation.mainScreens.auth.signUp.SignUpScreen
import com.example.testapp.presentation.mainScreens.auth.signUp.SignUpViewModel


@Composable
fun AppNavigation(
    signUpViewModel: SignUpViewModel,
    loginViewModel: LoginViewModel,
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Intro.route){
        composable(route = Screens.Intro.route){
            IntroScreen(navController = navController)
        }
        composable(route = Screens.SignUp.route){
            SignUpScreen(navController,signUpViewModel)
        }
        composable(route = Screens.Login.route){
            LoginScreen(navController,loginViewModel)
        }
        composable(route = Screens.Home.route){
            HomeScreen(navController,homeViewModel)
        }
        composable(route = "${Screens.City.route}/{cityId}",arguments = listOf(
            navArgument("cityId"){type = NavType.IntType}
        )){
            val id = it.arguments?.getInt("cityId")
            id?.let {
                // if id not null go to city screen
                CityScreen(id,navController,homeViewModel)

            }
        }

        composable(route = Screens.CommingSoon.route){
            CommingSoon(navController)
        }
    }
}