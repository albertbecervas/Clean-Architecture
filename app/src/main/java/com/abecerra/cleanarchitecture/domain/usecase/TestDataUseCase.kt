package com.abecerra.cleanarchitecture.domain.usecase

import com.abecerra.cleanarchitecture.domain.model.TestDataModel
import com.abecerra.cleanarchitecture.domain.repository.TestRepository
import io.reactivex.Single
import javax.inject.Inject


class TestDataUseCase @Inject constructor(private val testRepository: TestRepository) {
    fun getTestApi(): Single<TestDataModel> = testRepository.getTestApi()
    fun getTestDb(): Single<TestDataModel> = testRepository.getTestDb()

}