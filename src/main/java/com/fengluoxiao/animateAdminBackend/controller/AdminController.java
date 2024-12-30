package com.fengluoxiao.animateAdminBackend.controller;

import com.fengluoxiao.animateAdminBackend.model.Admin;
import com.fengluoxiao.animateAdminBackend.model.ApiResponse;
import com.fengluoxiao.animateAdminBackend.util.JwtUtil;
import com.fengluoxiao.animateAdminBackend.dao.AdminMapper;
import com.fengluoxiao.animateAdminBackend.util.PasswordEncoder;
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
    
    @Autowired
    private AdminMapper adminMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody Admin admin) {
        Admin dbAdmin = adminMapper.findByUsername(admin.getUsername());
        if (dbAdmin != null && passwordEncoder.matches(admin.getPassword(), dbAdmin.getPassword())) {
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
    
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody Admin admin) {
        // 检查用户名是否已存在
        if (adminMapper.findByUsername(admin.getUsername()) != null) {
            return ApiResponse.error("Username already exists");
        }
        
        // 加密密码
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        
        // 保存到数据库
        adminMapper.insert(admin);
        
        return ApiResponse.success("Admin created successfully");
    }
} 