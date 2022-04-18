package com.example.kopring.domain.user.controller

import com.example.kopring.domain.user.payload.request.LoginRequest
import com.example.kopring.domain.user.payload.request.SaveUserRequest
import com.example.kopring.domain.user.payload.response.UserInfoResponse
import com.example.kopring.domain.user.service.UserService
import com.example.kopring.global.security.jwt.payload.response.TokenResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController(
        private val userService: UserService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody request: SaveUserRequest) {
        userService.save(request)
    }

    @GetMapping("/info/{user-id}")
    fun getUserInfo(@PathVariable("user-id") userId: Long): UserInfoResponse {
        return userService.getUserInfo(userId)
    }

    @GetMapping("/info")
    fun getMyInfo(): UserInfoResponse {
        return userService.getMyInfo()
    }

    @PostMapping("/token")
    @ResponseStatus(HttpStatus.CREATED)
    fun login(@RequestBody request: LoginRequest): TokenResponse {
        return userService.login(request)
    }

}