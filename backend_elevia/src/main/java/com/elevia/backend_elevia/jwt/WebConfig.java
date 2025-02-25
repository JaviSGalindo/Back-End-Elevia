package com.elevia.backend_elevia.jwt;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Habilita MVC, importante para que CORS funcione correctamente
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500", "http://localhost:4200", "http://localhost:5500", "http://localhost:63342")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
