package com.example.kopring.domain.user.payload.request

data class SaveUserRequest(
        val accountId: String,
        val password: String,
        val name: String,
        val email: String,
        val age: Int
)