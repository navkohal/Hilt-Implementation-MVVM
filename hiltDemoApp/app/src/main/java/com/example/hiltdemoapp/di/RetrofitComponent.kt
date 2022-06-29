package com.example.mydaggerdemo.di

import com.example.hiltdemoapp.MainActivityViewModel
import dagger.Component
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Component

interface RetrofitComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}