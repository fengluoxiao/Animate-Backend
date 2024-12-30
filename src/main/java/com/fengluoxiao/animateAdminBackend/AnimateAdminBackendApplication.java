
package com.fengluoxiao.animateAdminBackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({
    "com.fengluoxiao.animateBackend.dao",
    "com.fengluoxiao.animateAdminBackend.dao"
})
public class AnimateAdminBackendApplication {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "admin");
        SpringApplication.run(AnimateAdminBackendApplication.class, args);
    }
} 