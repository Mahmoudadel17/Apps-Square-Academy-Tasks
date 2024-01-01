package com.example.cimacorner.di

import com.example.cimacorner.data.Constants
import com.example.cimacorner.data.remote.ApiService
import com.example.cimacorner.data.repository.MoviesRepositoryImpl
import com.example.cimacorner.data.repository.SearchRepositoryImpl
import com.example.cimacorner.domain.repository.MoviesRepository
import com.example.cimacorner.domain.repository.SearchRepository
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
    fun provideApiKey(): String {
        return Constants.ApiKey
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSearchRepository() : SearchRepository {
        return SearchRepositoryImpl(provideApiService(), provideApiKey())
    }

    @Provides
    @Singleton
    fun provideMoviesRepository() : MoviesRepository {
        return MoviesRepositoryImpl(provideApiService(), provideApiKey())
    }

}