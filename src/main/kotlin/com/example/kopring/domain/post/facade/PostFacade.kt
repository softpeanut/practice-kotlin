package com.example.kopring.domain.post.facade

import com.example.kopring.domain.post.entity.Post
import com.example.kopring.domain.post.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class PostFacade(
        private val postRepository: PostRepository
) {

    fun getById(id: Long): Post {
        return postRepository.findByIdOrNull(id) ?: throw RuntimeException("post not found")
    }

}