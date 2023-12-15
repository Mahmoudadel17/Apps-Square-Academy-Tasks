package com.example.testapp.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.example.testapp.data.Constants
import com.example.testapp.data.remote.ApiServices
import com.example.testapp.data.remote.AuthApiServices
import com.example.testapp.data.repository.ApiRepositoryImpl
import com.example.testapp.data.repository.AuthApiRepositoryImpl
import com.example.testapp.domain.ApiRepository
import com.example.testapp.domain.AuthApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // general Api services
    @Provides
    @Singleton
    fun providesRetrofit (): Retrofit = Retrofit.Builder().baseUrl(Constants.ApiServicesUrlBase).addConverterFactory(
        GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun providesApiServices () : ApiServices = providesRetrofit().create(ApiServices::class.java)


    @Provides
    @Singleton
    fun providesApiRepository():ApiRepository = ApiRepositoryImpl(providesApiServices())

    // -------------------------------------------------------------------------------------------------
    // Authentication Api Services
    @Provides
    @Singleton
    fun providesRetrofitAuth (): Retrofit = Retrofit.Builder().baseUrl(Constants.AuthApiServicesUrlBase).addConverterFactory(
        GsonConverterFactory.create()).build()


    @Provides
    @Singleton
    fun providesAuthApiServices () : AuthApiServices = providesRetrofitAuth().create(AuthApiServices::class.java)

    @Provides
    @Singleton
    fun providesAuthApiRepository(): AuthApiRepository = AuthApiRepositoryImpl(providesAuthApiServices())

    // -------------------------------------------------------------------------------------------------


    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(Constants.SharedPreferences_KEY, Context.MODE_PRIVATE)


    @Provides
    @Singleton
    fun provideTokenManager(sharedPreferences: SharedPreferences): TokenManager =
        TokenManager(sharedPreferences)

    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}