package com.abecerra.cleanarchitecture.data.database

import com.abecerra.cleanarchitecture.data.api.dto.TestDataDto
import com.abecerra.cleanarchitecture.core.base.BaseDao
import io.reactivex.Single

class TestDataDao : BaseDao<TestDataDto>() {
    override fun getItemById(id: String): Single<TestDataDto> {

        return Single.just(TestDataDto())
    }

    override fun addOrUpdate(item: TestDataDto) {


    }

    override fun addOrUpdate(items: List<TestDataDto>) {

    }

}