package com.example.testapp.presentation.mainScreens.auth.login

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.testapp.presentation.navigation.Screens

class LoginViewModel : ViewModel() {
    private var _state by mutableStateOf(
        LoginScreenState(
            phoneNumber = "",
            password = ""
        )
    )

    val state: State<LoginScreenState>
        get() = derivedStateOf { _state }



    fun onPhoneNumberChange(phoneNumber:String){
        _state = _state.copy(
            phoneNumber = phoneNumber,
            isErrorPhoneNumber = false,
            phoneNumberErrorMessage = ""
        )

    }


    fun onPasswordChange(password:String){
        _state = _state.copy(
            password = password,
            isErrorPassword = false,
            passwordErrorMessage = ""
        )

    }




    fun onIconButtonClick(){
        val newShowPassword = _state.showPassword.not()
        _state = _state.copy(
            showPassword = newShowPassword
        )
    }
    fun onLoginButtonClick(navController:NavHostController) {
        if (_state.phoneNumber.isEmpty()){
            _state=_state.copy(
                isErrorPhoneNumber = true,
                phoneNumberErrorMessage = "Please enter your phone number"
            )

        }
        if (_state.password.isEmpty()){
            _state=_state.copy(
                isErrorPassword = true,
                passwordErrorMessage = "Please enter your password"
            )

        }

        if (_state.password.isNotEmpty() && _state.phoneNumber.isNotEmpty()){
            navController.navigate(Screens.Home.route){
                    popUpTo(Screens.Login.route) {
                        inclusive = true
                    }
            }
        }

    }




}