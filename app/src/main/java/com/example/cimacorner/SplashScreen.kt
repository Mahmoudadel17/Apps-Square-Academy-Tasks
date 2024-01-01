package com.example.cimacorner

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.cimacorner.R
import com.example.cimacorner.presentation.components.TextWithFontSharp
import com.example.cimacorner.presentation.navigation.Screens
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen() {


    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        Image(
            painter = painterResource(id = R.drawable.main_splash),
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = "splash image",
            contentScale = ContentScale.Crop
        )
        TextWithFontSharp(
            name = stringResource(R.string.cimacorner),
            size =60
        )
    }


}