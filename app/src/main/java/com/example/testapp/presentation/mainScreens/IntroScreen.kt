package com.example.testapp.presentation.mainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testapp.R
import com.example.testapp.presentation.components.ButtonClickOn
import com.example.testapp.presentation.components.MyText
import com.example.testapp.presentation.navigation.Screens
import com.example.testapp.ui.theme.textLight

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IntroScreen(navController:NavHostController) {
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

          Text(
              text = stringResource(id = R.string.intro_title),
              style = TextStyle(
                  color = textLight,
                  fontSize = 80.sp,
                  fontFamily = FontFamily(Font(R.font.hiatus2)),
                  letterSpacing = 0.2.em,
              ),
              modifier = Modifier
                  .padding(top = 100.dp)

          )
        }

        // Add other content on top of the image
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            MyText(id =R.string.intro_plan_your, size = 25)
            MyText(id =R.string.intro_luxurious, size = 45)
            MyText(id =R.string.intro_vaction, size = 45)

            ButtonClickOn("Explore",15){
                // on click action, go to sign up screen and remove this screen from back stack.
                navController.navigate(Screens.SignUp.route){
                    popUpTo(Screens.Intro.route) {
                        inclusive = true
                    }
                }
            }
        }

    }
}

