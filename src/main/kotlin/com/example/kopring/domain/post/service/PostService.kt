package com.example.kopring.domain.post.service

import com.example.kopring.domain.post.entity.Post
import com.example.kopring.domain.post.facade.PostFacade
import com.example.kopring.domain.post.payload.request.PostRequest
import com.example.kopring.domain.post.payload.response.PostListResponse
import com.example.kopring.domain.post.payload.response.PostResponse
import com.example.kopring.domain.post.repository.PostRepository
import com.example.kopring.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostService(
        private val postRepository: PostRepository,
        private val userFacade: UserFacade,
        private val postFacade: PostFacade
) {

    fun save(request: PostRequest): Post {
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

    fun getList(): PostListResponse {
        val list: List<PostResponse> = postRepository.findAll()
                .map {
                    PostResponse(
                            id = it.id,
                            title = it.title,
                            content = it.content,
                            writerName = it.user.name,
                            writerAge = it.user.age
                    )
                }
                .toList()

        return PostListResponse(
                postList = list
        )
    }

    @Transactional
    fun updateById(id: Long, request: PostRequest): PostResponse {
        val post: Post = postFacade.getById(id)

        post.update(
                title = request.title,
                content = request.content
        )

        return PostResponse(
                id = post.id,
                title = post.title,
                content = post.content,
                writerName = post.user.name,
                writerAge = post.user.age
        )
    }

    fun deleteById(id: Long): PostResponse {
        val post: Post = postFacade.getById(id)

        postRepository.delete(post)

        return PostResponse(
                id = post.id,
                title = post.title,
                content = post.content,
                writerName = post.user.name,
                writerAge = post.user.age
        )
    }

}