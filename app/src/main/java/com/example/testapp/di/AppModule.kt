package com.example.testapp.di

import android.content.Context
import android.net.ConnectivityManager
import com.example.testapp.data.remote.ApiServices
import com.example.testapp.data.repository.ApiRepositoryImpl
import com.example.testapp.domain.ApiRepository
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

    @Provides
    @Singleton
    fun providesRetrofit (): Retrofit = Retrofit.Builder().baseUrl("https://aspen-73f2b-default-rtdb.firebaseio.com/").addConverterFactory(
        GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun providesApiServices () : ApiServices = providesRetrofit().create(ApiServices::class.java)

    @Provides
    @Singleton
    fun providesApiRepository():ApiRepository = ApiRepositoryImpl(providesApiServices())


    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}