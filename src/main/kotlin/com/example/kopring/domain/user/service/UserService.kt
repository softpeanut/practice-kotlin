package com.example.kopring.domain.user.service

import com.example.kopring.domain.user.entity.User
import com.example.kopring.domain.user.exception.PasswordNotCorrectException
import com.example.kopring.domain.user.facade.UserFacade
import com.example.kopring.domain.user.payload.request.LoginRequest
import com.example.kopring.domain.user.payload.request.SaveUserRequest
import com.example.kopring.domain.user.payload.response.UserInfoResponse
import com.example.kopring.domain.user.repository.UserRepository
import com.example.kopring.global.security.jwt.JwtTokenProvider
import com.example.kopring.global.security.jwt.payload.response.TokenResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val userFacade: UserFacade,
        private val passwordEncoder: PasswordEncoder,
        private val jwtTokenProvider: JwtTokenProvider
) {

    fun save(request: SaveUserRequest) {
        val user = User(
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                name = request.name,
                email = request.email,
                age = request.age
        )
        userRepository.save(user)
    }

    fun getUserInfo(userId: Long): UserInfoResponse {
        val user = userFacade.getById(userId)

        return UserInfoResponse(
                user.id,
                user.name,
                user.age
        )
    }

    fun getMyInfo(): UserInfoResponse {
        val currentUser = userFacade.getCurrentUser()

        return UserInfoResponse(
                currentUser.id,
                currentUser.name,
                currentUser.age
        )
    }

    fun login(request: LoginRequest): TokenResponse {
        val user = userFacade.getByAccountId(request.accountId)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotCorrectException.EXCEPTION
        }

        return jwtTokenProvider.getAccessToken(request.accountId)
    }

}