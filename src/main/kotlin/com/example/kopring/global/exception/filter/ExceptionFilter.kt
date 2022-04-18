package com.example.kopring.global.exception.filter

import com.example.kopring.global.exception.CustomException
import com.example.kopring.global.exception.InternalServerErrorException
import com.example.kopring.global.exception.error.BaseErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            logger.error(e.message)
            when (e) {
                is CustomException -> writeErrorCode(e, response)
                else -> writeErrorCode(InternalServerErrorException.EXCEPTION, response)
            }
        }
    }

    private fun writeErrorCode(exception: CustomException, response: HttpServletResponse) {
        val errorResponse = BaseErrorResponse.of(exception)

        response.characterEncoding = "UTF-8"
        response.status = errorResponse.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}