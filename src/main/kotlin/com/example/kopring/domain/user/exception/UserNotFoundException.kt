package com.example.kopring.domain.user.exception

import com.example.kopring.domain.user.exception.error.UserErrorCode
import com.example.kopring.global.exception.CustomException

class UserNotFoundException private constructor() : CustomException(error = UserErrorCode.USER_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }
}