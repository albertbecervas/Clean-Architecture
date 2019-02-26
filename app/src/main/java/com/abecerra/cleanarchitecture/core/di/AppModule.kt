package com.abecerra.cleanarchitecture.core.di

import com.abecerra.cleanarchitecture.core.App
import com.abecerra.cleanarchitecture.core.utils.AppSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [PresentationModule::class, DataModule::class])
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    @Provides
    @Singleton
    internal fun provideSharedPreferences(): AppSharedPreferences =
        AppSharedPreferences.getInstance()
}
