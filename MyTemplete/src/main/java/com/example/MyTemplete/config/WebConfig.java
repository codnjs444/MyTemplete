package com.example.MyTemplete.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 이 클래스가 설정 파일임을 나타냅니다.
@EnableWebMvc // Spring MVC 설정을 활성화합니다.
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 경로에 대해 CORS 설정을 적용합니다.
        registry.addMapping("/**")
                // allowedOrigins: 8081 포트에서 오는 요청을 허용합니다.
                .allowedOrigins("http://localhost:8081")
                // allowedMethods: 허용할 HTTP 메소드를 지정합니다.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // allowedHeaders: 허용할 HTTP 헤더를 지정합니다.
                .allowedHeaders("*")
                // allowCredentials: 자격 증명을 포함한 요청을 허용합니다.
                .allowCredentials(true);
    }
}