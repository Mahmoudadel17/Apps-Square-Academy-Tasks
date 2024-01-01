package com.example.cimacorner.presentation.navigation


sealed class Screens(val route:String){

    object Home:Screens(
        route = "home"
    )
    object Movie:Screens(
        route = "movie"
    )
    object Search:Screens(
        route = "search"
    )

}