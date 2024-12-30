package com.fengluoxiao.animateBackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@PropertySource("file:.env")
@EnableConfigurationProperties
public class DatabaseConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    public class DataSourceProperties {
        private String url;
        private String username;
        private String password;
        // getters and setters
    }
} 