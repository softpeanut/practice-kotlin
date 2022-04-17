package com.example.kopring.domain.post.controller

import com.example.kopring.domain.post.entity.Post
import com.example.kopring.domain.post.payload.request.PostRequest
import com.example.kopring.domain.post.payload.response.PostResponse
import com.example.kopring.domain.post.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/post")
@RestController
class PostController(
        private val postService: PostService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePost(request: PostRequest): Post {
        return postService.save(request)
    }

    @GetMapping("/{post-id}")
    fun getPostInfo(@PathVariable("post-id") postId: Long): PostResponse {
        return postService.getById(postId)
    }

    @PatchMapping("/{post-id}")
    fun updatePost(@PathVariable("post-id") postId: Long, @RequestBody request: PostRequest): PostResponse {
        return postService.updateById(postId, request)
    }

}