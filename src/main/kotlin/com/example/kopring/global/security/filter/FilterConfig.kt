package com.example.kopring.global.security.filter

import com.example.kopring.global.exception.filter.ExceptionFilter
import com.example.kopring.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val tokenFilter = TokenFilter(jwtTokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)

        builder.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, TokenFilter::class.java)
    }
}
