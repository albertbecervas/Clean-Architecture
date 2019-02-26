package com.abecerra.cleanarchitecture.data.api

import com.abecerra.cleanarchitecture.data.api.dto.ResponseDto
import com.abecerra.cleanarchitecture.data.api.dto.TestDataDto
import io.reactivex.Single
import retrofit2.http.GET


interface TestDataService {

    @GET("/api/json/get/VJ6PC7HVL")
    fun test(): Single<ResponseDto<TestDataDto>>

    @GET("/api/json/get/VkBrw1hN8")
    fun testCorrupted(): Single<ResponseDto<TestDataDto>>

}