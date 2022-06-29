package com.example.hiltdemoapp.di

import com.example.mydaggerdemo.di.RetorfitServiceInterface
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

    val baseUrl = "https://api.github.com/search/" //repositories?q=newyork

    @Singleton
    @Provides
    fun getRetrofiotServiceInterface(retrofit: Retrofit) : RetorfitServiceInterface {
        return retrofit.create(RetorfitServiceInterface ::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}