package com.example.kopring.domain.user.service

import com.example.kopring.domain.user.entity.User
import com.example.kopring.domain.user.facade.UserFacade
import com.example.kopring.domain.user.payload.request.SaveUserRequest
import com.example.kopring.domain.user.payload.response.UserInfoResponse
import com.example.kopring.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val userFacade: UserFacade
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

    fun getUserInfo(userId: Long): UserInfoResponse {
        val user = userFacade.findById(userId)

        return UserInfoResponse(
                user.id,
                user.name,
                user.age
        )
    }

}