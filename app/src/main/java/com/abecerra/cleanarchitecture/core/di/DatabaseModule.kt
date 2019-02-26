package com.abecerra.cleanarchitecture.core.di

import com.abecerra.cleanarchitecture.data.database.TestDataDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTestDataDao() = TestDataDao()

}