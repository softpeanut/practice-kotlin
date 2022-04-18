package com.example.kopring.domain.user.exception

import com.example.kopring.global.exception.CustomException
import com.example.kopring.global.exception.error.ErrorCode

class UserNotFoundException private constructor(): CustomException(errorCode = ErrorCode.USER_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }
}