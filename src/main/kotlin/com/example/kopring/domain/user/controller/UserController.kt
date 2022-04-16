package com.example.kopring.domain.user.controller

import com.example.kopring.domain.user.payload.request.SaveUserRequest
import com.example.kopring.domain.user.payload.response.UserInfoResponse
import com.example.kopring.domain.user.service.UserService
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

    @GetMapping("/{user-id}")
    fun getUserInfo(@PathVariable("user-id") userId: Long): UserInfoResponse {
        return userService.getUserInfo(userId)
    }

}