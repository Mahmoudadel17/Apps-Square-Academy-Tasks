package com.example.testapp.domain

import com.example.testapp.data.remote.dto.LoginRequestBody
import com.example.testapp.data.remote.dto.LoginResponse
import com.example.testapp.data.remote.dto.SignUpRequestBody
import com.example.testapp.data.remote.dto.SignUpResponse

interface AuthApiRepository {
    suspend fun login(loginRequestBody: LoginRequestBody):LoginResponse

    suspend fun signUp(signUpRequestBody: SignUpRequestBody):SignUpResponse
}