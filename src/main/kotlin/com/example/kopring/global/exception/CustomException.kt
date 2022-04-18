package com.example.kopring.global.exception

import com.example.kopring.global.exception.error.ErrorResponse

open class CustomException(private val error: ErrorResponse) : RuntimeException() {

    val status: Int
        get() = error.status

    override val message: String
        get() = error.message
}