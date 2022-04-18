package com.example.kopring.global.security.jwt.exception

import com.example.kopring.global.exception.CustomException
import com.example.kopring.global.security.jwt.exception.error.JwtErrorCode

class TokenValidException private constructor() : CustomException(JwtErrorCode.TOKEN_VALID) {

    companion object {
        @JvmField
        val EXCEPTION = TokenValidException()
    }
}