package com.abecerra.cleanarchitecture.data.repository

import com.abecerra.cleanarchitecture.data.api.TestDataService
import com.abecerra.cleanarchitecture.data.api.dto.mapper.TestDataDtoMapper
import com.abecerra.cleanarchitecture.data.database.TestDataDao
import com.abecerra.cleanarchitecture.domain.model.TestDataModel
import com.abecerra.cleanarchitecture.domain.repository.TestRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepositoryImpl @Inject constructor(
    private val api: TestDataService,
    private val testDataDao: TestDataDao,
    private val testDataDtoMapper: TestDataDtoMapper
) : TestRepository {

    override fun getTestApi(): Single<TestDataModel> {
        return api.testCorrupted().flatMap {
            testDataDao.addOrUpdate(it.data)
            Single.just(it.data)
        }.map {
            testDataDtoMapper.map(it)
        }
    }

    override fun getTestDb(): Single<TestDataModel> {
        return testDataDao.getItemById("0").flatMap {
            Single.just(it)
        }.map {
            testDataDtoMapper.map(it)
        }
    }

}

