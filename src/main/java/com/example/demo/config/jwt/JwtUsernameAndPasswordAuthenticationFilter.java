package com.example.demo.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager; // the AuthenticationManager interface is an important part of the Spring Security framework and is used to manage the authentication of users in an application.
    private final SecretKey secretKey;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper() // The object Mapper reads the value from the input stream and then puts it into that UserAndPassAUthReq class
                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class); // the readValue method  deserializes a JSON string to a Java object.
            Authentication authentication = new UsernamePasswordAuthenticationToken( // usernamePasswordAuthenticationToken is a useful class for representing authenticated users in a Java application
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );
           return authenticationManager.authenticate(authentication); // Checking Credentials in authenticate method
        } catch (IOException e){
            throw new IllegalAccessError("Something went wrong");
        }
    }

    @Override // this method will be executed once the user successfully authenticated ( good credentials )
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        // Creating token based on user infos
        String token = Jwts.builder()
                .setSubject(authResult.getName()) // Setting the subject of the token by affecting either a username or an email
                .claim("authorities",authResult.getAuthorities()) // This method is used to add custom claims to a JWT
                .setIssuedAt(new Date()) // Record in wich date , time the token was recorder or issued
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(JwtConfig.TOKEN_EXPIRATION_AFTER_DAYS)))
                .signWith(secretKey)
                .compact(); // The compact representation of a JWT is a string that contains the JWT's header, payload, and signature, encoded using base64Url encoding as String .

        response.addHeader(JwtConfig.getAuthorizationHeader(), JwtConfig.TOKEN_PREFIX + token); // Sending the token back to the client.
    }
}