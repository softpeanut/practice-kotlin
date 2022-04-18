package com.example.kopring.global.security.jwt.exception

import com.example.kopring.global.exception.CustomException
import com.example.kopring.global.security.jwt.exception.error.JwtErrorCode

class TokenSignatureException private constructor() : CustomException(JwtErrorCode.TOKEN_SIGNATURE) {

    companion object {
        @JvmField
        val EXCEPTION = TokenSignatureException()
    }
}