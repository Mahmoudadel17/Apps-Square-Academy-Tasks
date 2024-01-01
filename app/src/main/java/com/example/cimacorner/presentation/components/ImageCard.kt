package com.example.cimacorner.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cimacorner.data.Constants
import com.example.cimacorner.ui.theme.DarkComponentColor2

@Composable
fun ImageCard(
    posterLink:String,
    title:String,
    yearOfProduction:String
    ) {
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

    ) {
        Box {
            AsyncImage(
                model = "${Constants.baseUrlPoster}$posterLink",
                contentDescription = "Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column (
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ){
                Text(
                    text = title,
                    fontSize = 12.sp,
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        ),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = yearOfProduction,
                    modifier = Modifier
                        .padding(start = 3.dp)
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        ),
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    ),
                    textAlign = TextAlign.Center
                )
            }


        }
    }
}

