package com.example.testapp.presentation.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.testapp.R
import com.example.testapp.ui.theme.textLight

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IntroScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Add image here as a background
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Add other content on top of the image
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

          Text(text = stringResource(id = R.string.intro_title), color = textLight)
        }
    }
}

@Composable
fun MyText(text:String) {
    Text(text = text,style = MaterialTheme.typography.displaySmall.merge(
        TextStyle(
            color = Color.White
        )
    ))
}