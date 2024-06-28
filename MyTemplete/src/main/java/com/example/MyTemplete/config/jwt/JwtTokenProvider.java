package com.example.MyTemplete.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // 토큰 서명을 위한 256비트 길이의 SECRET KEY 생성
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 토큰 유효 시간 설정
    private final long EXPIRATION_MS = 1000 * 60 * 60; // 1시간

    // 사용자 ID 기반 토큰 생성 메서드
    public String createToken(String userId) {
    	// 클레임 객체 생성 및 사용자ID 설정
        Claims claims = Jwts.claims().setSubject(userId);
        // 현재 시간 저장
        Date now = new Date();
        // 만료 시간 설정
        Date expiryDate = new Date(now.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Token을 해석하여 사용자 ID 추출하는 Method
    public String getUserIdFromJWT(String token) {
    	// Token을 parsing 하여 Claims info 가져옴
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        // Claims에서 사용자 ID 추출하여 반환
        return claims.getSubject();
    }

    // Token이 유효한지 검증하는 Method
    public boolean validateToken(String token) {
    	// Token을 parsing하여 예외가 없을 시 Token이 유효하다 판단
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
