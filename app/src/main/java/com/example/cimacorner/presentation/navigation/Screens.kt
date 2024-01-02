package com.example.cimacorner.presentation.navigation


sealed class Screens(val route:String){

    object Home:Screens(
        route = "home"
    )
    object Details:Screens(
        route = "details"
    )
    object Search:Screens(
        route = "search"
    )

}