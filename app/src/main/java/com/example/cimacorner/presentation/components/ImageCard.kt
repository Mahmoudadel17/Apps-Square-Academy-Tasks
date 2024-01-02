package com.example.cimacorner.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cimacorner.data.Constants
import com.example.cimacorner.ui.theme.DarkComponentColor2

@Composable
fun ImageCard(
    posterLink:String?="",
    title:String,
    yearOfProduction:String,
    onMovieClick:()->Unit
    ) {

    val brush = animatedShimmer()



    Card(
        modifier = Modifier
            .padding(6.dp)
            .height(280.dp)
            .width(240.dp)
            .shadow(
                elevation = 16.dp,
                spotColor = DarkComponentColor2,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                // go to details screen
                onMovieClick()
            }

    ) {
        Box {
            AsyncImage(
                model = "${Constants.baseUrlPoster}$posterLink",
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = brush)
                ,
                contentScale = ContentScale.Crop,



            )

            Column (
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ){
                TextMovie(
                    text = title,
                    fontSize = 12,
                )
                TextMovie(
                    text = yearOfProduction,
                    fontSize = 10,
                    fontWeight = FontWeight.Bold
                )

            }


        }
    }
}


@Composable
fun DetailsImageCard(posterLink: String?="",height:Int) {
    Surface{
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = "${Constants.baseUrlPoster}$posterLink",
                contentDescription = "Image",
                contentScale = ContentScale.FillBounds
                , modifier = Modifier
                    .fillMaxWidth()
                    .height(height.dp)
            )

        }
    }
}