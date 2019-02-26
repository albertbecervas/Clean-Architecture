package com.abecerra.cleanarchitecture.data.api.dto.mapper

import com.abecerra.cleanarchitecture.core.utils.extensions.*
import com.abecerra.cleanarchitecture.data.api.dto.TestDataDto
import com.abecerra.cleanarchitecture.domain.model.TestDataModel
import com.abecerra.cleanarchitecture.core.base.BaseMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestDataDtoMapper @Inject constructor() : BaseMapper<TestDataDto, TestDataModel>() {
    override fun map(from: TestDataDto): TestDataModel {
        return with(from) {
            TestDataModel(
                string = dataString.toString(),
                integer = dataInteger.toInt(),
                double = dataDouble.toDouble(),
                float = dataFloat.toFloat(),
                boolean = dataBoolean.toBoolean(),
                list = arrayListOf()
            )
        }
    }
}