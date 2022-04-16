package com.example.kopring.domain.post.repository

import com.example.kopring.domain.post.entity.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Long> {
}