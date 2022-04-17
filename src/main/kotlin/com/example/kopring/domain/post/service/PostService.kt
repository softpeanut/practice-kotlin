package com.example.kopring.domain.post.service

import com.example.kopring.domain.post.entity.Post
import com.example.kopring.domain.post.facade.PostFacade
import com.example.kopring.domain.post.payload.request.SavePostRequest
import com.example.kopring.domain.post.payload.response.PostResponse
import com.example.kopring.domain.post.repository.PostRepository
import com.example.kopring.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class PostService(
        private val postRepository: PostRepository,
        private val userFacade: UserFacade,
        private val postFacade: PostFacade
) {

    fun save(request: SavePostRequest): Post {
        val user = userFacade.getById(1)

        val post = Post(
                title = request.title,
                content = request.content,
                user = user
        )

        return postRepository.save(post)
    }

    fun getById(id: Long): PostResponse {
        val post: Post = postFacade.getById(id)

        return PostResponse(
                id = post.id,
                title = post.title,
                content = post.content,
                writerName = post.user.name,
                writerAge = post.user.age
        )
    }

}