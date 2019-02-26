package com.abecerra.cleanarchitecture.presentation.model.mapper

import com.abecerra.cleanarchitecture.core.base.BaseBidirectionalMapper
import com.abecerra.cleanarchitecture.domain.model.TestDataModel
import com.abecerra.cleanarchitecture.presentation.model.TestData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestDataMapper @Inject constructor() : BaseBidirectionalMapper<TestDataModel, TestData>() {
    override fun map(from: TestDataModel): TestData {

        return with(from) {
            TestData(
                testData = generateTestDataString(this)
            )
        }

    }

    override fun inverseMap(from: TestData): TestDataModel {
        return with(from) {
            TestDataModel(
                string = testData,
                integer = 0,
                double = 0.0,
                float = 0f,
                boolean = false,
                list = arrayListOf()
            )
        }
    }

    private fun generateTestDataString(testDataModel: TestDataModel): String {
        return with(testDataModel) { "String: $string , integer: $integer , double: $double , float: $float , boolean: $boolean , list: $list" }
    }

}