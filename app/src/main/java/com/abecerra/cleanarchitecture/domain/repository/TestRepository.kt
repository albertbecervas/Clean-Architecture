package com.abecerra.cleanarchitecture.domain.repository

import com.abecerra.cleanarchitecture.domain.model.TestDataModel
import io.reactivex.Single

interface TestRepository {
    fun getTestApi(): Single<TestDataModel>
    fun getTestDb(): Single<TestDataModel>
}