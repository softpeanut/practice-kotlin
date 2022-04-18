package com.example.kopring.global.security.jwt.exception.error

import com.example.kopring.global.exception.error.ErrorResponse

enum class JwtErrorCode(
        override val status: Int,
        override val message: String
) : ErrorResponse {

    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_SIGNATURE(401, "Token signature"),
    TOKEN_VALID(401, "Token valid"),
    TOKEN_UNEXPECTED(401, "Token unexpected")


}