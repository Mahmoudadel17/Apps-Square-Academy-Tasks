package com.example.cimacorner.presentation.navigation




import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.presentation.Home.HomeScreen
import com.example.cimacorner.presentation.Home.HomeScreenViewModel
import com.example.cimacorner.presentation.details.DetailsScreen
import com.example.cimacorner.presentation.search.SearchScreen
import com.example.cimacorner.presentation.search.SearchScreenViewModel

@Composable
fun AppNavigation(
    homeScreenViewModel: HomeScreenViewModel,
    searchScreenViewModel: SearchScreenViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Home.route){

        composable(route = Screens.Home.route){
            HomeScreen(homeScreenViewModel = homeScreenViewModel,navController = navController)
        }

        composable(route = Screens.Details.route){
            val movie = navController.previousBackStackEntry?.savedStateHandle?.get<Movie> ("movie")

            movie?.let {
                // if movie not null go to details screen
                DetailsScreen(movie = movie, navController = navController)
            }
        }


        composable(route = Screens.Search.route){
            SearchScreen(searchScreenViewModel,navController)
        }
    }
}