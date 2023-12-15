package com.example.testapp.di

import android.content.SharedPreferences
import com.example.testapp.data.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class TokenManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(Constants.TOKEN_KEY, token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(Constants.TOKEN_KEY, null)
    }


    // my be use it if need to logout.
    fun clearToken() {
        sharedPreferences.edit().remove(Constants.TOKEN_KEY).apply()
    }
}
