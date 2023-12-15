package com.example.testapp.presentation.mainScreens.auth.login

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.testapp.data.remote.dto.LoginRequestBody
import com.example.testapp.data.remote.dto.LoginResponse
import com.example.testapp.di.TokenManager
import com.example.testapp.domain.AuthApiRepository
import com.example.testapp.presentation.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authApiRepository: AuthApiRepository,
    private val tokenManager: TokenManager)
    : ViewModel() {
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


//            // try to login.
//            viewModelScope.launch(Dispatchers.IO){
//               val loginResponse =  authApiRepository.login(
//                    LoginRequestBody(
//                    _state.phoneNumber,
//                    _state.password
//                ))
//
//                if (loginResponse.token.isNotEmpty()){
//                    tokenManager.saveToken(loginResponse.token)
//
//                    // go to home screen after save token in sharedPreferences
//                    withContext(Dispatchers.Main){
//                        navController.navigate(Screens.Home.route){
//                            popUpTo(Screens.Login.route) {
//                                inclusive = true
//                            }
//                        }
//                    }
//                }
//
//            }
//
//
//
            // save token as example to save user
            tokenManager.saveToken("token")
            navController.navigate(Screens.Home.route){
                    popUpTo(Screens.Login.route) {
                        inclusive = true
                    }
            }
        }

    }




}