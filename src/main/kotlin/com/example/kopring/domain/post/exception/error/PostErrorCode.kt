package com.example.kopring.domain.post.exception.error

import com.example.kopring.global.exception.error.ErrorResponse

enum class PostErrorCode(
        override val status: Int,
        override val message: String
): ErrorResponse {

    POST_NOT_FOUND(404, "Post not found")

}