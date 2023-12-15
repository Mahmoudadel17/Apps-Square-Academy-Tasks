package com.example.testapp.data.repository

import android.content.SharedPreferences
import com.example.testapp.data.remote.AuthApiServices
import com.example.testapp.data.remote.dto.LoginRequestBody
import com.example.testapp.data.remote.dto.LoginResponse
import com.example.testapp.data.remote.dto.SignUpRequestBody
import com.example.testapp.data.remote.dto.SignUpResponse
import com.example.testapp.domain.AuthApiRepository
import javax.inject.Inject

class AuthApiRepositoryImpl @Inject constructor(private val api : AuthApiServices) : AuthApiRepository {
    override suspend fun login(loginRequestBody: LoginRequestBody): LoginResponse {
        val response = api.login(loginRequestBody)

        if (response.isSuccessful){
            val responseBody = response.body()
            responseBody?.let { return  it }
        }
        return LoginResponse("")
    }

    override suspend fun signUp(signUpRequestBody: SignUpRequestBody): SignUpResponse {
        val response = api.signUp(signUpRequestBody)

        if (response.isSuccessful){
            val responseBody = response.body()
            responseBody?.let { return  it }
        }
        return SignUpResponse("")
    }

}