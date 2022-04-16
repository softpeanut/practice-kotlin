package com.example.kopring.domain.post.entity

import com.example.kopring.domain.user.entity.User
import javax.persistence.*

@Entity
open class Post(
        title: String,
        content: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        val user: User
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var title = title
        protected set

    var content = content
        protected set
}