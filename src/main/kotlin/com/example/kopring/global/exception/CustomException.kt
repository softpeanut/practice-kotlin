package com.example.kopring.global.exception

import com.example.kopring.global.exception.error.ErrorCode

open class CustomException(private val errorCode: ErrorCode) : RuntimeException() {

    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message
}