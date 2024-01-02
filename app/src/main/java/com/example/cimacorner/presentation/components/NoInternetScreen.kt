package com.example.cimacorner.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cimacorner.R
import com.example.cimacorner.ui.theme.BackgroundColor
import com.example.cimacorner.ui.theme.RedComponentColor1
import com.example.cimacorner.ui.theme.TextColor


@Composable
fun NoInternetScreen() {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(BackgroundColor)
    ){
        Text(
            text = "No Internet Available",
            style = TextStyle(
                color = RedComponentColor1,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        LottieAnimationShow(
            animationResId = R.raw.no_internet,
            size = 250,
            padding = 10,
            paddingBottom = 0
        )
        Text(
            text = "Please open your settings and enable internet by turning wifi or mobile data",
            style = TextStyle(
                color = TextColor.copy(alpha = 0.6f),
                fontSize = 14.sp,
            ),
            modifier = Modifier.padding(horizontal = 50.dp),
            textAlign = TextAlign.Center
        )


    }
}