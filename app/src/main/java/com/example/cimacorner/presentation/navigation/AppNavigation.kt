package com.example.cimacorner.presentation.navigation




import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cimacorner.presentation.Home.HomeScreen
import com.example.cimacorner.presentation.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Home.route){

        composable(route = Screens.Home.route){
            HomeScreen()
        }

        composable(route = "${Screens.Movie.route}/{movieId}",arguments = listOf(
            navArgument("movieId"){type = NavType.IntType}
        )){
            val id = it.arguments?.getInt("movieId")
            id?.let {
                // if id not null go to city screen

            }
        }

        composable(route = Screens.Search.route){

        }
    }
}