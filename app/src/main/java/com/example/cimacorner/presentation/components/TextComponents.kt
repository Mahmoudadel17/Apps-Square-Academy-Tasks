package com.example.cimacorner.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.cimacorner.R
import com.example.cimacorner.ui.theme.RedComponentColor1
import com.example.cimacorner.ui.theme.TextColor


@Composable
fun TextWithFontSharp(name: String, size:Int, color: Color = RedComponentColor1, modifier: Modifier = Modifier) {
    Text(
        text = name,
        style = TextStyle(
            color = color,
            fontSize = size.sp,
            fontFamily = FontFamily(Font(R.font.dcc_sharp_distress_black_by_dccanim)),
            letterSpacing = 0.1.em,
        ),
        modifier = modifier
            .padding(top = 100.dp)

    )
}


@Composable
fun TextMovie(text:String, fontSize:Int, fontWeight : FontWeight = FontWeight.Normal) {
    Text(
        text = text,
        fontSize = fontSize.sp,
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
        textAlign = TextAlign.Center,
        fontWeight =  fontWeight
    )
}

@Composable
fun TextTitle(title:String,size: Int = 18) {
    Text(
        text = title ,
        maxLines = 2,
        style = TextStyle(
            color = TextColor,
            fontWeight = FontWeight.Bold,
            fontSize = size.sp
        ),
        textAlign = TextAlign.Center,
    )

}
@Composable
fun TextVoteAverage(voteAverage:Double) {
    Text(
        text = "%.1f".format(voteAverage) ,
        modifier = Modifier.padding(start = 4.dp),
        style = TextStyle(
        color = TextColor,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        )
    )

}


@Composable
fun TextContent(content:String) {
    Text(
        text = content ,
        modifier = Modifier.padding(8.dp),
        style = TextStyle(
            color = TextColor,
            fontSize = 16.sp,
        ),
        textAlign = TextAlign.Justify
    )
}

