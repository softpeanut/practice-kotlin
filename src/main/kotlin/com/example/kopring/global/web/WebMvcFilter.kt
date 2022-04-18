package com.example.kopring.global.web

import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class WebMvcFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000")
            response.setHeader("Access-Control-Allow-Credentials", "true")
            response.setHeader("Access-Control-Allow-Methods", "*")
            response.setHeader("Access-Control-Max-Age", "3600")
            response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization")

            if ("OPTIONS".equals(request.method, ignoreCase = true)) {
                response.status = HttpServletResponse.SC_OK
            }
        } catch (e: Exception) {
            logger.error(e.message)
        }

        filterChain.doFilter(request, response)
    }
}