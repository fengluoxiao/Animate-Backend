package com.fengluoxiao.animateBackend.controller;

import com.fengluoxiao.animateBackend.model.ApiResponse;
import com.fengluoxiao.animateBackend.model.Admin;
import com.fengluoxiao.animateBackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Claims;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody Admin admin) {
        // 这里添加实际的用户验证逻辑
        if ("admin".equals(admin.getUsername()) && "password".equals(admin.getPassword())) {
            String token = jwtUtil.generateToken(admin.getUsername(), "ROLE_ADMIN");
            return ApiResponse.success(token);
        }
        return ApiResponse.error("Invalid credentials");
    }
    
    @GetMapping("/dashboard")
    public ApiResponse<Map<String, Object>> getDashboard(@RequestHeader("Authorization") String token) {
        try {
            Claims claims = jwtUtil.validateToken(token.replace("Bearer ", ""));
            // 添加仪表盘数据逻辑
            return ApiResponse.success(Map.of(
                "totalUsers", 100,
                "totalOrders", 50,
                "revenue", 10000
            ));
        } catch (Exception e) {
            return ApiResponse.error("Invalid token");
        }
    }
} 