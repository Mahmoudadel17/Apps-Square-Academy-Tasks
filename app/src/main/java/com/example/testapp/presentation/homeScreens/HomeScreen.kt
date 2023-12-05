package com.example.testapp.presentation.homeScreens

import android.os.Handler
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.navigation.NavHostController
import com.example.testapp.R
import com.example.testapp.presentation.navigation.Screens
import com.example.testapp.ui.theme.textDarkHint

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel) {
    LaunchedEffect(Unit ){
        homeViewModel.refresh()
    }

    val cities = homeViewModel.cities.collectAsState()
    val state = homeViewModel.state.value
    var doubleBackToExitPressedOnce = false
    val activity = LocalOnBackPressedDispatcherOwner.current as ComponentActivity
    val context = LocalContext.current

    if (state){
        // if network connection work and can be load remote data
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
                items(cities.value){
                    CityCard(city = it){cityId->
                        navController.navigate("${Screens.City.route}/$cityId")
                    }
                }
            }


        }
    }else{
        navController.navigate(Screens.CommingSoon.route)
    }


    //Back Handler
    BackHandler(onBack = {
        if (doubleBackToExitPressedOnce) {
            finishAffinity(activity)
        } else {
            doubleBackToExitPressedOnce = true
            Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 1000)
        }
    })
}