package com.example.testapp.presentation.navigation

sealed class Screens(val route:String){
    object Intro:Screens(
        route = "intro"
    )  object SignUp:Screens(
        route = "signUp"
    )  object Login:Screens(
        route = "login"
    )
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