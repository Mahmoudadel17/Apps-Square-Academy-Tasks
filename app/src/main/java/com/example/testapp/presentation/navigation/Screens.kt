package com.example.testapp.presentation.navigation

sealed class Screens(val route:String){

    object Home:Screens(
        route = "home"
    )
    object City:Screens(
        route = "city"
    )
    object CommingSoon:Screens(
        route = "commingSoon"
    )
}