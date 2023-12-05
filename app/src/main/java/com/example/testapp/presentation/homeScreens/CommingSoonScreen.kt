package com.example.testapp.presentation.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testapp.R
import com.example.testapp.presentation.components.ButtonClickOn
import com.example.testapp.presentation.navigation.Screens
import com.example.testapp.ui.theme.textDarkHint


@Composable
fun CommingSoon(navController: NavHostController) {
    Column (
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo signUp",
            modifier = Modifier
                .size(280.dp)
        )
        Text(
            text = stringResource(id = R.string.comming_soon),
            style = TextStyle(
                color = textDarkHint,
                fontSize = 32.sp,
                fontWeight = FontWeight.W600,
                fontFamily = FontFamily(Font(R.font.inter)),
            ),
        )
        ButtonClickOn(
            buttonText = stringResource(id = R.string.refresh)
            , paddingValue = 30
        ) {
            // on click action
            navController.navigate(Screens.Home.route){
                popUpTo(Screens.CommingSoon.route){
                    inclusive = true
                }
            }
        }

    }

}