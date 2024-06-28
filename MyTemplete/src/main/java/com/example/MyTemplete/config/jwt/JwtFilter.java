package com.example.MyTemplete.config.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 요청이 들어올 떄 마다 한 번씩 실행되는 필터
public class JwtFilter extends OncePerRequestFilter {

	// 필터 생성 시 JwtTokenProvider 받아옴
    private final JwtTokenProvider tokenProvider;

    public JwtFilter(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    	// 요청에서 JWT 토큰 추출
        String token = getJwtFromRequest(request);

        // Token이 존재하고 유효한지 검사
        if (token != null && tokenProvider.validateToken(token)) {
            String userId = tokenProvider.getUserIdFromJWT(token);
            // 사용자 인증 객체 생성
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId, null, null);
            // 요청 정보 인증 객체에 설정
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            // Spring Security Context에 인증 객체 설정
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 요청을 다음 Filter로 전달
        filterChain.doFilter(request, response);
    }

    // HTTP 요청의 헤더에서 JWT 토큰 추출
    private String getJwtFromRequest(HttpServletRequest request) {
    	// 요청의 헤더에서 Authorization 값 추출
        String bearerToken = request.getHeader("Authorization");
        // 헤더 값이 Bearer로 시작하는 지 확인
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
