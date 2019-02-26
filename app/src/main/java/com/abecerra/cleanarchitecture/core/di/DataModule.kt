package com.abecerra.cleanarchitecture.core.di

import dagger.Module

@Module(includes = [RepositoryModule::class, ApiModule::class, DatabaseModule::class])
class DataModule {

}
