package com.example.kopring.global.exception.error

enum class ErrorCode(
        override val status: Int,
        override val message: String
): ErrorResponse {

    POST_NOT_FOUND(404, "Post not found"),
    USER_NOT_FOUND(404, "User not found")

}