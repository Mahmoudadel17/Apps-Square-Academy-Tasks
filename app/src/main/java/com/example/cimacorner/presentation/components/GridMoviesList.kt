package com.example.cimacorner.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.cimacorner.data.remote.dto.Movie


@Composable
fun MoviesGridList(movies: List<Movie>) {

    LazyVerticalGrid(
        // Set the number of columns in the grid
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(movies){ movie ->
                MovieCard(movie)

        }
    }
}


@Composable
fun MovieCard(movie: Movie) {

}







