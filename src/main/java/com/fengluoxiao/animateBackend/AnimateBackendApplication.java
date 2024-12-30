package com.fengluoxiao.animateBackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({
    "com.fengluoxiao.animateBackend.dao",
    "com.fengluoxiao.animateAdminBackend.dao"
})
public class AnimateBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimateBackendApplication.class, args);
    }
} 