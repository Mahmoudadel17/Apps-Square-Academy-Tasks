package com.example.testapp.presentation.mainScreens.auth.login

data class LoginScreenState(
    val phoneNumber:String,
    val isErrorPhoneNumber:Boolean = false,
    val phoneNumberErrorMessage:String = "",

    val password:String,
    val isErrorPassword:Boolean = false ,
    val passwordErrorMessage:String = "",

    val showPassword:Boolean = false,
)
