package com.example.kopring.global.security.jwt

import com.example.kopring.global.security.auth.AuthDetailsService
import com.example.kopring.global.security.jwt.exception.TokenExpiredException
import com.example.kopring.global.security.jwt.exception.TokenSignatureException
import com.example.kopring.global.security.jwt.exception.TokenUnExpectedException
import com.example.kopring.global.security.jwt.exception.TokenValidException
import com.example.kopring.global.security.jwt.payload.response.TokenResponse
import com.example.kopring.global.security.properties.JwtProperties
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
        private val authDetailsService: AuthDetailsService,
        private val jwtProperties: JwtProperties
) {

    fun authenticate(token: String): Authentication {
        val subject = getClaimsBody(token).subject
        val authDetails = authDetailsService.loadUserByUsername(subject)
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    fun getAccessToken(accountId: String): TokenResponse {
        val accessToken = generateToken(accountId, jwtProperties.accessTokenExp)
        return TokenResponse(accessToken)
    }

    private fun generateToken(accountId: String, expiration: Long): String {
        return JwtProperties.TOKEN_PREFIX + Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
                .setSubject(accountId)
                .setIssuedAt(Date())
                .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
                .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? =
            request.getHeader(JwtProperties.TOKEN_HEADER_NAME)

    fun parseToken(token: String): String {
        if (token.startsWith(JwtProperties.TOKEN_PREFIX)) {
            return token.replace(JwtProperties.TOKEN_PREFIX, "")
        }
        throw TokenValidException.EXCEPTION
    }

    private fun getClaimsBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                    .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw TokenExpiredException.EXCEPTION
                is SignatureException -> throw TokenSignatureException.EXCEPTION
                is MalformedJwtException -> throw TokenValidException.EXCEPTION
                else -> throw TokenUnExpectedException.EXCEPTION
            }
        }
    }

}