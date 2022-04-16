package com.example.kopring.domain.post.service

import com.example.kopring.domain.post.entity.Post
import com.example.kopring.domain.post.payload.request.SavePostRequest
import com.example.kopring.domain.post.repository.PostRepository
import com.example.kopring.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class PostService(
        private val postRepository: PostRepository,
        private val userFacade: UserFacade
) {

    fun save(request: SavePostRequest): Post {
        val user = userFacade.findById(1)

        val post = Post(
                title = request.title,
                content = request.content,
                user = user
        )

        return postRepository.save(post)
    }

}