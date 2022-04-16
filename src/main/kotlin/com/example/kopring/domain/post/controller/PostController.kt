package com.example.kopring.domain.post.controller

import com.example.kopring.domain.post.entity.Post
import com.example.kopring.domain.post.payload.request.SavePostRequest
import com.example.kopring.domain.post.service.PostService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/post")
@RestController
class PostController(
        private val postService: PostService
) {

    fun savePost(request: SavePostRequest): Post {
        return postService.save(request)
    }

}