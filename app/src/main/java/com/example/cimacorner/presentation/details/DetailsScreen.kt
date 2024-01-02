package com.example.cimacorner.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cimacorner.data.remote.dto.Movie
import com.example.cimacorner.presentation.components.DetailsImageCard
import com.example.cimacorner.presentation.components.TextContent
import com.example.cimacorner.presentation.components.TextTitle
import com.example.cimacorner.presentation.components.TextVoteAverage
import com.example.cimacorner.ui.theme.BackgroundColor


@Composable
fun DetailsScreen(movie: Movie, navController: NavHostController) {
    val brush =  Brush.linearGradient(
        colors = listOf(
            Color.Gray.copy(alpha = 0.6f),
            Color.Gray.copy(alpha = 0.2f),
            Color.Gray.copy(alpha = 0.6f),

            )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ){
        Row (
            modifier = Modifier.padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                Modifier
                    .size(50.dp)
                    .padding(5.dp)
                    .background(brush, shape = CircleShape)
                    .clickable {
                               navController.popBackStack()
                    },
                tint = BackgroundColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            TextTitle(title = movie.name)

        }
        DetailsImageCard(movie.poster,350)
        Row (
            modifier = Modifier.padding( 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            TextTitle(title = movie.yearOfProduction,size = 26 )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "star",
                tint = Color.Yellow,
                modifier = Modifier.size(30.dp)
            )
            TextVoteAverage(voteAverage = movie.voteAverage)

        }
        TextContent(movie.overView)
    }
}




