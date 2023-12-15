package com.example.testapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignUpRequestBody(
//    @SerializedName("phone_number")
    val phoneNumber:String,
    val email:String,
    val city:String,
    val password:String,
)
