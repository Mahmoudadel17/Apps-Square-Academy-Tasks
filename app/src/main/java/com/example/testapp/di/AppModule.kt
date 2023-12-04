package com.example.testapp.di

import com.example.testapp.data.remote.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit (): Retrofit = Retrofit.Builder().baseUrl("https://aspen-73f2b-default-rtdb.firebaseio.com/").addConverterFactory(
        GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun providesApiServices () : ApiServices = providesRetrofit().create(ApiServices::class.java)

}