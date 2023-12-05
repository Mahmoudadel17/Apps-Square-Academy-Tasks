package com.example.testapp.presentation.homeScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.testapp.R
import com.example.testapp.data.remote.dto.City
import com.example.testapp.ui.theme.background
import com.example.testapp.ui.theme.componentsColor
import com.example.testapp.ui.theme.textDarkHint
import com.example.testapp.ui.theme.textDescriptionColor


@Composable
fun CityScreen(id: Int, navController: NavHostController, homeViewModel: HomeViewModel) {
    val city = homeViewModel.getCityById(id)
    city?.let {
        CityView(city = it, navController = navController )
    }
}

@Composable
fun CityView(city: City, navController: NavHostController,) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        IconButton(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(componentsColor),
            onClick = { navController.popBackStack() },
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "back icon",
                tint = background,
            )
        }

        AsyncImage(
            model =city.imageLink,
            modifier = Modifier
                .padding(top = 30.dp)
                .clip(RoundedCornerShape(20.dp))
                .height(280.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            contentDescription = "city Image",
            error = painterResource(id = R.drawable.placeholder),
            placeholder = painterResource(id = R.drawable.placeholder),
        )

        Row (
            modifier = Modifier.padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = city.cityName,
                style = TextStyle(
                    color = textDarkHint,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = FontFamily(Font(R.font.montserratb)),
                ),
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "${city.numberOfReviews} Reviews",
                style = TextStyle(
                    color = componentsColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily(Font(R.font.montserratb)),
                ),

                )

        }
        Text(
            text = city.cityDescription,
            style = TextStyle(
                color = textDescriptionColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily(Font(R.font.abel)),
            ),
            modifier = Modifier.padding(top = 15.dp)
        )

    }
}