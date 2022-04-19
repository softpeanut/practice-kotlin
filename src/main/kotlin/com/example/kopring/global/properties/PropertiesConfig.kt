package com.example.kopring.global.properties

import com.example.kopring.global.security.properties.JwtProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@EnableConfigurationProperties(value = [JwtProperties::class])
@Configuration
class PropertiesConfig