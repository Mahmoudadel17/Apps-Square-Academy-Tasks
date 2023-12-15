package com.example.testapp.presentation.mainScreens.auth.signUp

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.testapp.data.remote.dto.SignUpRequestBody
import com.example.testapp.di.TokenManager
import com.example.testapp.domain.AuthApiRepository
import com.example.testapp.presentation.navigation.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel  @Inject constructor(
    private val authApiRepository: AuthApiRepository,
    private val tokenManager: TokenManager)
    : ViewModel() {
    private var _state by mutableStateOf(
        SignUpScreenState(
            phoneNumber = "",
            email = "",
            city = "",
            password = ""
        )
    )

    val state: State<SignUpScreenState>
        get() = derivedStateOf { _state }



    fun onPhoneNumberChange(phoneNumber:String){
        _state = _state.copy(
            phoneNumber = phoneNumber,
            isErrorPhoneNumber = false,
            phoneNumberErrorMessage = ""
        )

    }


    fun onEmailChange(email:String){
        _state = _state.copy(
            email = email,
            isErrorEmail = false,
            emailErrorMessage = ""
        )

    }
    fun onCityChange(city:String){
        _state = _state.copy(
            city = city,
            isErrorCity = false,
            cityErrorMessage = ""
        )

    }

    fun onPasswordChange(password:String){
        _state = _state.copy(
            password = password,
            isErrorPassword = false,
            passwordErrorMessage = ""
        )

    }

    fun onTermsSelect(){
        val newTermsAgree = _state.termsAgree.not()
        _state = _state.copy(
            termsAgree = newTermsAgree
        )

    }



    fun onIconButtonClick(){
        val newShowPassword = _state.showPassword.not()
        _state = _state.copy(
            showPassword = newShowPassword
        )
    }
    fun onSignUpButtonClick(navController: NavHostController) {
        if (_state.phoneNumber.isEmpty()){
            _state=_state.copy(
                isErrorPhoneNumber = true,
                phoneNumberErrorMessage = "Please enter your phone number"
            )

        }
        if (_state.email.isEmpty()){
            _state=_state.copy(
                isErrorEmail = true,
                emailErrorMessage = "Please enter your email"
            )

        }
        if (_state.city.isEmpty()){
            _state=_state.copy(
                isErrorCity = true,
                cityErrorMessage = "Please enter your city"
            )

        }
        if (_state.password.isEmpty()){
            _state=_state.copy(
                isErrorPassword = true,
                passwordErrorMessage = "Please enter your password"
            )

        }

        if (_state.password.isNotEmpty() && _state.email.isNotEmpty()
            && _state.city.isNotEmpty() && _state.phoneNumber.isNotEmpty()){

//            // try to sign up.
//            viewModelScope.launch(Dispatchers.IO){
//               val signUpResponse =  authApiRepository.signUp(
//                    SignUpRequestBody(
//                    _state.phoneNumber,
//                    _state.email,
//                    _state.city,
//                    _state.password
//                ))
//
//                if (signUpResponse.token.isNotEmpty()){
//                    tokenManager.saveToken(signUpResponse.token)
//
//                    // go to home screen after save token in sharedPreferences
//                    withContext(Dispatchers.Main){
//                        navController.navigate(Screens.Home.route){
//                            popUpTo(Screens.SignUp.route) {
//                                inclusive = true
//                            }
//                        }
//                    }
//                }
//
//            }

            // save token as example to save user
            tokenManager.saveToken("token")
            navController.navigate(Screens.Home.route){
                popUpTo(Screens.SignUp.route) {
                    inclusive = true
                }
            }



        }

    }


}