package com.example.securityjwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String RAW_SECRET_KEY = "aaaabbbbccccddddeeeeffffgggghhhh";

    public String createJws(String subject) {
        Key key = Keys.hmacShaKeyFor(RAW_SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        String jws = Jwts.builder()
            .setSubject(subject)
            .signWith(key)
            .compact();

        return jws;
    }

    public boolean isValid(String jws) {
        Key key = Keys.hmacShaKeyFor(RAW_SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        try {
            Jws<Claims> parsed = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jws);

            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
