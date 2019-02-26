package com.abecerra.cleanarchitecture.core.di

import com.abecerra.cleanarchitecture.data.repository.TestRepositoryImpl
import com.abecerra.cleanarchitecture.domain.repository.TestRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindInProgressRepository(repository: TestRepositoryImpl): TestRepository

}
