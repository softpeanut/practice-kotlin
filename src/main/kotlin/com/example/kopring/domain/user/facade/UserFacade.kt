package com.example.kopring.domain.user.facade

import com.example.kopring.domain.user.entity.User
import com.example.kopring.domain.user.exception.UserNotFoundException
import com.example.kopring.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserFacade(
        private val userRepository: UserRepository
) {

    fun getById(id: Long): User {
        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException.EXCEPTION;
    }

}