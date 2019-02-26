package com.abecerra.cleanarchitecture.data.api.dto

data class ResponseDto<K>(
    var data: K,
    var error: ErrorDto?,
    var message: String?,
    var status: String?
)