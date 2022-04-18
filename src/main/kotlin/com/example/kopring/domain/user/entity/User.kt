package com.example.kopring.domain.user.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
        accountId: String,
        password: String,
        name: String,
        email: String,
        age: Int
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0;

    var accountId = accountId
        protected set

    var password = password
        protected set

    var name = name
        protected set

    var email = email
        protected set

    var age = age
        protected set
}