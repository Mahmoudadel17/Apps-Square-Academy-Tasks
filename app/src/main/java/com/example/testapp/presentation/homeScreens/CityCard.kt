package com.example.testapp.presentation.homeScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testapp.R
import com.example.testapp.data.allCities
import com.example.testapp.data.remote.dto.City
import com.example.testapp.ui.theme.componentsColor
import com.example.testapp.ui.theme.textDarkHint


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CityCard(
   city: City ,
    onCityClick:(Int)->Unit
) {
    Row (
        modifier = Modifier.padding(10.dp).fillMaxWidth()
            .clickable {
                       // on city click
                       onCityClick(city.id)

        },
        verticalAlignment = Alignment.CenterVertically,
    ){
        Surface(
            shape = RoundedCornerShape(24.dp),
            shadowElevation = 20.dp,
            ) {
            AsyncImage(
                model = city.imageLink,
                modifier = Modifier
                    .height(200.dp)
                    .width(180.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "city Image",
                error = painterResource(id = R.drawable.placeholder),
                placeholder = painterResource(id = R.drawable.placeholder),
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        )
        {
            Text(
                text = city.cityName,
                style = TextStyle(
                    color = textDarkHint,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                ),
            )
            Text(
                text = "${city.numberOfReviews} Reviews",
                style = TextStyle(
                    color = componentsColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                ),
            )
        }
    }

}