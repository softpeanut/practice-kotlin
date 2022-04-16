package com.example.kopring.domain.user.payload.request

data class SaveUserRequest(
        val name: String,
        val email: String,
        val age: Int
)