package com.fengluoxiao.animateBackend;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fengluoxiao.animateBackend.dao")
public class AnimateBackendApplication {
    private static final Logger logger = LoggerFactory.getLogger(AnimateBackendApplication.class);

    public static void main(String[] args) {
        // 加载.env文件
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
        
        System.setProperty("spring.profiles.active", "client");
        logger.info("Database config: {}:{}/{}", 
            System.getProperty("DB_HOST"), 
            System.getProperty("DB_PORT"), 
            System.getProperty("DB_NAME"));
        SpringApplication.run(AnimateBackendApplication.class, args);
    }
} 