package com.twintea.spacehr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.twintea.spacehr.mapper")
@EnableScheduling
public class SpacehrApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpacehrApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // 设置允许跨域请求的域名
                        .allowedOriginPatterns("*")
                        // 再次加入前端Origin  localhost！=127.0.0.1
                        .allowedOrigins("http://localhost")
                        // 是否允许证书（cookies）
                        .allowCredentials(true)
                        // 设置允许的方法
                        .allowedMethods("*")
                        //允许请求头
                        .allowedHeaders("*")
                        // 跨域允许时间
                        .maxAge(3600);
            }
        };
    }
}
