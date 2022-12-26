package com.example.demo.config.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtSecretKey {
    @Bean // This method is a utility method provided by the Spring Security framework that generates a secret key for use in HMAC operations.
    public SecretKey secretKey(){
        return Keys.hmacShaKeyFor(JwtConfig.SECRET_KEY.getBytes());
    }
}
