package com.example.kopring.global.exception.error

enum class GlobalErrorCode(
        override val status: Int,
        override val message: String
) : ErrorResponse {

    INTERNAL_SERVER_ERROR(500, "Internal server error")

}