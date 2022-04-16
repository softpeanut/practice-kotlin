package com.example.kopring.domain.user.service

import com.example.kopring.domain.user.entity.User
import com.example.kopring.domain.user.payload.request.SaveUserRequest
import com.example.kopring.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository
) {

    fun save(request: SaveUserRequest) {
        val user = User(
                name = request.name,
                email = request.email,
                age = request.age
        )
        userRepository.save(user)

        println("success save user")
    }

}