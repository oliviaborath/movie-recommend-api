package com.oliviaborath.movierecommendationapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // URL pattern for which CORS is enabled
                .allowedOrigins("http://localhost:3000") // Allow requests from the React app domain and port
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                .allowedHeaders("*") // Allowed request headers (you can customize this if needed)
                .allowCredentials(true); // Allow sending cookies in cross-origin requests (if applicable)
    }
}
