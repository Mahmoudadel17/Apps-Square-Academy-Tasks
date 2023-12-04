package com.example.testapp.presentation.homeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.data.allCities
import com.example.testapp.ui.theme.textDarkHint

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {


        LazyColumn{

            item{
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo signUp",
                        modifier = Modifier
                            .size(150.dp)
                            .weight(1f),
                    )
                }
                Text(
                    text = stringResource(id = R.string.home_popular_cities),
                    style = TextStyle(
                        color = textDarkHint,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
            items(allCities){
                CityCard(city = it, onCityClick = {})
            }
        }


    }
}