package com.example.kopring.global.exception

import com.example.kopring.global.exception.error.GlobalErrorCode

class InternalServerErrorException private constructor() : CustomException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {

        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }
}