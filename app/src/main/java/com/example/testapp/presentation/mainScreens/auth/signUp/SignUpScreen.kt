package com.example.testapp.presentation.mainScreens.auth.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.presentation.components.ButtonClickOn
import com.example.testapp.presentation.components.CityEditText
import com.example.testapp.presentation.components.EmailEditText
import com.example.testapp.presentation.components.PasswordEditText
import com.example.testapp.presentation.components.PhoneEditText
import com.example.testapp.presentation.mainScreens.auth.AuthScreenState
import com.example.testapp.ui.theme.background
import com.example.testapp.ui.theme.componentsColor
import com.example.testapp.ui.theme.textDark
import com.example.testapp.ui.theme.textDarkHint
import com.example.testapp.ui.theme.textHint

val auth = AuthScreenState(phoneNumber = "", email = "", city = "", password = "")

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back",
                Modifier.size(30.dp)
            )
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
                text = stringResource(id = R.string.signUp),
                style = TextStyle(
                    color = textDark,
                    fontSize = 37.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = stringResource(id = R.string.signUp_hint),
                style = TextStyle(
                    color = textDarkHint,
                    fontSize = 16.sp,
                ),
            )
            Column(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                PhoneEditText(
                    phoneNumber = auth.phoneNumber,
                    isPhoneNumberError = auth.isErrorPhoneNumber,
                    phoneNumberErrorMessage = auth.phoneNumberErrorMessage,
                    onValueChange = {}
                )
                EmailEditText(
                    email = auth.email,
                    isErrorEmail = auth.isErrorEmail,
                    emailErrorMessage = auth.emailErrorMessage,
                    onValueChange ={}
                )
                CityEditText(
                    city = auth.city,
                    isCityError = auth.isErrorCity,
                    cityErrorMessage = auth.cityErrorMessage,
                    onValueChange ={}
                )
                PasswordEditText(
                    password = auth.password,
                    isErrorPassword = auth.isErrorPassword,
                    passwordErrorMessage = auth.passwordErrorMessage,
                    showPassword = auth.showPassword,
                    onValueChange ={}
                ) {
                    // on show password click
                }
            }


            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(
                        checkedColor = componentsColor,
                        uncheckedColor = componentsColor,
                        checkmarkColor = background
                    )
                )
                
                Text(

                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = textDark)) {
                            append(stringResource(id = R.string.signUp_termsAgree1))
                        }
                        append(" ")
                        withStyle(style = SpanStyle(color = componentsColor)) {
                            append(stringResource(id = R.string.signUp_termsAgree2))
                        }
                    },
                    fontSize = 14.sp,
                )

            }



        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonClickOn(
                buttonText = stringResource(id = R.string.signUp),
                paddingValue = 30
            ) {
                // on click action
            }
            Row {
                Text(
                    text = stringResource(id = R.string.signUp_haveAccount),
                    style = TextStyle(
                        color = textHint
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string.login),
                    style = TextStyle(
                        color = componentsColor,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }
}