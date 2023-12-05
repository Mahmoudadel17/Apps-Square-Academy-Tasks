package com.example.testapp.presentation.mainScreens.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testapp.R
import com.example.testapp.presentation.components.ButtonClickOn
import com.example.testapp.presentation.components.PasswordEditText
import com.example.testapp.presentation.components.PhoneEditText
import com.example.testapp.presentation.navigation.Screens
import com.example.testapp.ui.theme.componentsColor
import com.example.testapp.ui.theme.textDark
import com.example.testapp.ui.theme.textDarkHint
import com.example.testapp.ui.theme.textHint


@Composable
fun LoginScreen(navController: NavHostController, loginViewModel: LoginViewModel) {
    val state = loginViewModel.state.value
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ){

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo signUp",
                modifier = Modifier
                    .weight(0.60f)
                    .size(60.dp)

            )
        }
        Column (
            modifier = Modifier.padding(top = 10.dp)
        ){
            Text(
                text = stringResource(id = R.string.login),
                style = TextStyle(
                    color = textDark,
                    fontSize = 37.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = stringResource(id = R.string.login_hint),
                style = TextStyle(
                    color = textDarkHint,
                    fontSize = 16.sp,
                ),
            )
            Column(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                PhoneEditText(
                    phoneNumber = state.phoneNumber,
                    isPhoneNumberError = state.isErrorPhoneNumber,
                    phoneNumberErrorMessage = state.phoneNumberErrorMessage,
                    onValueChange = {phone->loginViewModel.onPhoneNumberChange(phone)}
                )

                PasswordEditText(
                    password = state.password,
                    isErrorPassword = state.isErrorPassword,
                    passwordErrorMessage = state.passwordErrorMessage,
                    showPassword = state.showPassword,
                    onValueChange ={password->loginViewModel.onPasswordChange(password)}
                ) {
                    // on show password click
                    loginViewModel.onIconButtonClick()
                }
            }


        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonClickOn(
                buttonText = stringResource(id = R.string.login),
                paddingValue = 30
            ) {
                // on click action
                loginViewModel.onLoginButtonClick(navController)
            }
            Row(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login_d_haveAccount),
                    style = TextStyle(
                        color = textHint
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string.signUp),
                    style = TextStyle(
                        color = componentsColor,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.clickable {
                        // on sign up text click
                        navController.navigate(Screens.SignUp.route)

                    }
                )
            }
        }
    }
}