package com.example.kopring.domain.user.exception

import com.example.kopring.domain.user.exception.error.UserErrorCode
import com.example.kopring.global.exception.CustomException

class PasswordNotCorrectException private constructor() : CustomException(UserErrorCode.PASSWORD_NOT_CORRECT) {

    companion object {

        @JvmField
        val EXCEPTION = PasswordNotCorrectException()
    }
}