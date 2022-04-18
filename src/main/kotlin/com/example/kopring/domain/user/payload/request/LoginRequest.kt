package com.example.kopring.domain.user.payload.request

data class LoginRequest(
        val accountId: String,
        val password: String
)