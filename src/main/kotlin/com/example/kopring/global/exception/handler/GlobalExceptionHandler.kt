package com.example.kopring.global.exception.handler

import com.example.kopring.global.exception.CustomException
import com.example.kopring.global.exception.error.BaseErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun customException(e: CustomException): ResponseEntity<BaseErrorResponse> {
        return ResponseEntity(
                BaseErrorResponse.of(e),
                HttpStatus.valueOf(e.status)
        )
    }

}