package com.example.kopring.domain.user.repository

import com.example.kopring.domain.user.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}