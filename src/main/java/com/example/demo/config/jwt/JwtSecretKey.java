package com.example.demo.config.jwt;

import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Configuration
public class JwtSecretKey {
    @Bean // This method is is used to create a secret key using an SHA1 algorithm
    public SecretKey secretKey(){
        return Keys.hmacShaKeyFor(JwtConfig.SECRET_KEY.getBytes());
    }
}
