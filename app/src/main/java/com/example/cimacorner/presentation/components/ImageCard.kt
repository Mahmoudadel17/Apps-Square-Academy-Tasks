package com.example.cimacorner.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cimacorner.data.Constants
import com.example.cimacorner.data.moviess
import com.example.cimacorner.ui.theme.DarkComponentColor2

@Composable
fun ImageCard(posterLink:String,title:String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(280.dp)
            .width(220.dp)
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
            Text(
                text = title,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
                    .padding(12.dp),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun ImageCardPreview() {
    ImageCard(moviess[0].poster, moviess[0].name)
}