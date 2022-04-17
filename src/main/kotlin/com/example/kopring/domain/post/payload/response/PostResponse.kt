package com.example.kopring.domain.post.payload.response

data class PostResponse(
        val id: Long,
        val title: String,
        val content: String,
        val writerName: String,
        val writerAge: Int
)