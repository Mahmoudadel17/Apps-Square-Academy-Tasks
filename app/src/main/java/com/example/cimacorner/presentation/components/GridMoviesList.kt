package com.example.cimacorner.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.presentation.navigation.Screens


@Composable
fun MoviesGridList(movies: List<Movie>, navController: NavHostController,onEndScroll:()->Unit={}) {


    LazyVerticalGrid(
        // Set the number of columns in the grid
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(movies){ movie ->
                MovieCard(movie){
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "movie",
                        value = it
                    )
                    navController.navigate(Screens.Details.route)

                }

            if (movie == movies.last()){
                onEndScroll()
            }

        }
    }
}


@Composable
fun MovieCard(movie: Movie,onMovieClick:(Movie)->Unit) {
    ImageCard(posterLink = movie.poster, title = movie.name, yearOfProduction = movie.yearOfProduction){
        onMovieClick(movie)
    }
}





