package com.example.testapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.ui.theme.componentsColor
import com.example.testapp.ui.theme.textLight



@Composable
fun MyText(id:Int,size:Int) {
    Text(
        text = stringResource(id = id),
        style = TextStyle(
            color = textLight,
            fontSize = size.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(R.font.montserrat)),
        ),
    )
}

@Composable
fun ButtonClickOn(buttonText:String,paddingValue:Int ,onButtonClick:() -> Unit ) {
    Button (colors = ButtonDefaults.buttonColors(containerColor = componentsColor),
        enabled = true,
        onClick = {onButtonClick()},
        modifier = Modifier
            .padding(8.dp, top =paddingValue.dp)
            .height(48.dp)
            .fillMaxWidth(1f),
        shape = RoundedCornerShape(16.dp)

    ){
        Text(text = buttonText, fontSize = 10.sp, style = TextStyle(color = textLight))
    }
}