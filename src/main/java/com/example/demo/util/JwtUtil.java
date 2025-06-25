package com.example.demo.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // ⚠️ 운영 환경에서는 외부 설정에서 key 가져오도록 분리하세요.
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationMillis = 1000 * 60 * 60; // 1시간

    /**
     * JWT 토큰 생성
     * @param username 사용자 이름 (또는 고유한 식별자)
     * @return JWT 문자열
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // 사용자 ID
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

    /**
     * JWT 토큰 파싱 및 검증
     * @param token JWT 문자열
     * @return Claims (username 등 포함된 정보)
     */
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 토큰이 만료되었는지 여부
     */
    public boolean isTokenExpired(String token) {
        try {
            Claims claims = parseToken(token);
            return claims.getExpiration().before(new Date());
        } catch (JwtException e) {
            return true;
        }
    }
}
