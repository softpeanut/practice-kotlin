package com.example.kopring.global.security.jwt.exception

import com.example.kopring.global.exception.CustomException
import com.example.kopring.global.security.jwt.exception.error.JwtErrorCode

class TokenExpiredException private constructor() : CustomException(JwtErrorCode.TOKEN_EXPIRED) {

    companion object {
        @JvmField
        val EXCEPTION = TokenExpiredException()
    }
}