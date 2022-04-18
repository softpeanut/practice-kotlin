package com.example.kopring.domain.post.exception

import com.example.kopring.domain.post.exception.error.PostErrorCode
import com.example.kopring.global.exception.CustomException

class PostNotFoundException private constructor() : CustomException(error = PostErrorCode.POST_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = PostNotFoundException()
    }
}