package com.example.cimacorner.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.cimacorner.R
import com.example.cimacorner.ui.theme.RedComponentColor1


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
