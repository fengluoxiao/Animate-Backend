package com.fengluoxiao.animateBackend.controller;

import com.fengluoxiao.animateBackend.model.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TestController {
    
    @GetMapping("/test")
    public ApiResponse<String> test() {
        return ApiResponse.success("Hello World!");
    }
} 