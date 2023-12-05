package com.example.testapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.ui.theme.componentsColor
import com.example.testapp.ui.theme.inputFieldColor
import com.example.testapp.ui.theme.textDark
import com.example.testapp.ui.theme.textDarkHint
import com.example.testapp.ui.theme.textHint
import com.example.testapp.ui.theme.textLight

@Composable
fun MyText(id:Int,size:Int) {
    Text(
        text = stringResource(id = id),
        style = TextStyle(
            color = textLight,
            fontSize = size.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(Font(R.font.montserratb)),
        ),
    )
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldColors() : TextFieldColors {

    return TextFieldDefaults.textFieldColors(
        // text color
        focusedTextColor = textDark,
        unfocusedTextColor = textDark,
        errorTextColor = textDark,

        cursorColor = textDarkHint,
        // icon color
        focusedTrailingIconColor = textHint,
        unfocusedTrailingIconColor = textHint,
        errorTrailingIconColor = textHint,

        // color
        containerColor = inputFieldColor,
        errorContainerColor = inputFieldColor,
        // Indicator color
        focusedIndicatorColor =  Color.Transparent,
        unfocusedIndicatorColor =  Color.Transparent,
        errorIndicatorColor =  Color.Transparent,

        )
}


@Composable
fun LabelText(id:Int) {
    Text(
        text = stringResource(id = id),
        style = TextStyle(
            color = textDark,
            fontSize = 14.sp,
        ),
    )
}





@Composable
fun PhoneEditText(
    phoneNumber:String ,
    isPhoneNumberError:Boolean ,
   phoneNumberErrorMessage:String,
    onValueChange:(String) -> Unit) {
   Column {
       LabelText(id = R.string.phone)
     TextField(
           placeholder = { Text(stringResource(id = R.string.phone), fontSize = 10.sp,color = textHint) },
           value = phoneNumber,
           onValueChange = {
               onValueChange(it)
           },
           colors = TextFieldColors(),
           shape = RoundedCornerShape(16.dp),
           modifier = Modifier
               .height(50.dp)
               .fillMaxWidth(),
           isError = isPhoneNumberError,

           )
       Row {
           Text(
               phoneNumberErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                   .padding(top = 3.dp, start = 25.dp), color = Color.Red
           )
           Spacer(modifier = Modifier.weight(1f))

       }
   }
}




@Composable
fun CityEditText(
    city:String ,
    isCityError:Boolean ,
    cityErrorMessage:String,
    onValueChange:(String) -> Unit) {
    Column {
        LabelText(id = R.string.city)
        TextField(
            placeholder = { Text(stringResource(id = R.string.city), fontSize = 10.sp,color = textHint) },
            value = city,
            onValueChange = {
                onValueChange(it)
            },
            colors = TextFieldColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(50.dp)

                .fillMaxWidth(),
            isError = isCityError,
        )
        Row {
            Text(
                cityErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                    .padding(top = 3.dp, start = 25.dp), color = Color.Red
            )
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}







@Composable
fun EmailEditText(
    email:String ,
    isErrorEmail:Boolean ,
    emailErrorMessage:String,
    onValueChange:(String) -> Unit) {
    Column {
        LabelText(id = R.string.email)

        TextField(
            placeholder = { Text(stringResource(id = R.string.email), fontSize = 10.sp,color = textHint) },
            value = email,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            onValueChange = {
                onValueChange(it)

            },
            colors = TextFieldColors(),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
            ,
            isError = isErrorEmail,

        )

        Row {
            Text(
                emailErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                    .padding(top = 3.dp, start = 25.dp), color = Color.Red
            )
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}


@Composable
fun PasswordEditText(
    password:String ,
    isErrorPassword:Boolean ,
    passwordErrorMessage:String ,
    showPassword:Boolean,
    onValueChange:(String) -> Unit,
    onIconButtonClick:() -> Unit
) {
   Column {
       LabelText(id = R.string.password)

   TextField(
           placeholder = { Text(stringResource(id = R.string.password), fontSize = 10.sp,color = textHint) },
           value = password,
           isError = isErrorPassword,
           visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
           onValueChange = {
               onValueChange(it)
           },
           colors =  TextFieldColors(),
           shape = RoundedCornerShape(16.dp),
           modifier = Modifier
               .height(50.dp)
               .fillMaxWidth(),
           trailingIcon = {
               IconButton(onClick = {
                   onIconButtonClick()
               }) {
                   Icon(painter = painterResource(id = if(showPassword) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                       contentDescription = "password icon")
               }
           },

       )
       Row {
           Text(
               passwordErrorMessage, style = MaterialTheme.typography.bodyMedium, modifier = Modifier
                   .padding(top = 3.dp, start = 25.dp), color = Color.Red
           )
           Spacer(modifier = Modifier.weight(1f))

       }
   }

}





@Composable
fun ButtonClickOn(buttonText:String,paddingValue:Int ,onButtonClick:() -> Unit ) {
    Button (colors = ButtonDefaults.buttonColors(containerColor = componentsColor),
        enabled = true,
        onClick = {onButtonClick()},
        modifier = Modifier
            .padding(8.dp, top = paddingValue.dp)
            .height(48.dp)
            .fillMaxWidth(1f),
        shape = RoundedCornerShape(16.dp)

    ){
        Text(text = buttonText, fontSize = 12.sp, style = TextStyle(color = textLight))
    }
}

