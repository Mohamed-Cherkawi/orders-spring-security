package com.example.demo.config.jwt;

import org.springframework.http.HttpHeaders;

public class JwtConfig {
    public static final String SECRET_KEY = "thiskeyissosososossososososossosoossososoososlongthatyoucaaaaaaaaaaaaaaaantunderstandittttttttttttttttttttttttttttttttttt";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final Integer TOKEN_EXPIRATION_AFTER_DAYS = 6; // the more it is less the more you secure your users

    private JwtConfig() {}

    public static String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }

}
