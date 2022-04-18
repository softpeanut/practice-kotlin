package com.example.kopring.domain.user.facade

import com.example.kopring.domain.user.entity.User
import com.example.kopring.domain.user.exception.UserNotFoundException
import com.example.kopring.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
        private val userRepository: UserRepository
) {

    fun getById(id: Long): User {
        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException.EXCEPTION
    }

    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION
    }

    fun getCurrentUser(): User {
        val currentUserAccountId = getAuthenticationName()
        return getByAccountId(currentUserAccountId)
    }

    private fun getAuthenticationName(): String {
        return SecurityContextHolder.getContext().authentication.name
    }

}