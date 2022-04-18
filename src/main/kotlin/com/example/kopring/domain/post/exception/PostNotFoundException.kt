package com.example.kopring.domain.post.exception

import com.example.kopring.global.exception.CustomException
import com.example.kopring.global.exception.error.ErrorCode

class PostNotFoundException private constructor(): CustomException(errorCode = ErrorCode.POST_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = PostNotFoundException()
    }
}