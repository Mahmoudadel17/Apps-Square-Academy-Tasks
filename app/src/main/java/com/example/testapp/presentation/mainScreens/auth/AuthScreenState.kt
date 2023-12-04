package com.example.testapp.presentation.mainScreens.auth

data class AuthScreenState(
    val phoneNumber:String,
    val isErrorPhoneNumber:Boolean = false,
    val phoneNumberErrorMessage:String = "",

    val email:String,
    val isErrorEmail:Boolean = false,
    val emailErrorMessage:String = "",

    val city:String,
    val isErrorCity:Boolean = false,
    val cityErrorMessage:String = "",

    val password:String,
    val isErrorPassword:Boolean = false ,
    val passwordErrorMessage:String = "",

    val showPassword:Boolean = false,
    val termsAgree:Boolean = false,
)
