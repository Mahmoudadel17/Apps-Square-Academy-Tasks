package com.example.testapp.data.remote

import com.example.testapp.data.remote.dto.LoginRequestBody
import com.example.testapp.data.remote.dto.LoginResponse
import com.example.testapp.data.remote.dto.SignUpRequestBody
import com.example.testapp.data.remote.dto.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiServices {
    @POST("sign-up")
    suspend fun signUp(@Body signUpRequestBody: SignUpRequestBody): Response<SignUpResponse>


    @POST("login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody): Response<LoginResponse>

}