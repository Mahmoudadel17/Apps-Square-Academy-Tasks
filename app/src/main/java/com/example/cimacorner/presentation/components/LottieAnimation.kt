package com.example.cimacorner.presentation.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieAnimationShow(animationResId: Int, size:Int, padding:Int,paddingBottom:Int) {


    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(animationResId)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 1f,
        restartOnPlay = false

    )

    LottieAnimation(
        composition,
        progress,
        modifier = Modifier.padding(top = padding.dp, bottom = paddingBottom.dp).size(size.dp),
    )


}