package com.fengluoxiao.animateBackend.controller;

import com.fengluoxiao.animateBackend.model.ApiResponse;
import com.fengluoxiao.animateBackend.model.AnimateUser;
import com.fengluoxiao.animateBackend.service.AnimateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AnimateUserController {
    
    @Autowired
    private AnimateUserService animateUserService;
    
    @GetMapping("/getallname")
    public ApiResponse<List<AnimateUser>> getAllAnimateUsers() {
        return ApiResponse.success(animateUserService.findAll());
    }
    
    @GetMapping("/getname/{id}")
    public ApiResponse<AnimateUser> getAnimateUserById(@PathVariable Integer id) {
        return animateUserService.findById(id)
                .map(ApiResponse::success)
                .orElse(ApiResponse.error("Record not found"));
    }
    
    @PostMapping("/createname")
    public ApiResponse<AnimateUser> createAnimateUser(@RequestBody AnimateUser animateUser) {
        try {
            return ApiResponse.success(animateUserService.save(animateUser));
        } catch (Exception e) {
            return ApiResponse.error("Failed to create record: " + e.getMessage());
        }
    }
    
    @PutMapping("/updatename/{id}")
    public ApiResponse<AnimateUser> updateAnimateUser(@PathVariable Integer id, @RequestBody AnimateUser animateUser) {
        return animateUserService.findById(id)
                .map(existingAnimateUser -> {
                    animateUser.setId(id);
                    return ApiResponse.success(animateUserService.update(animateUser));
                })
                .orElse(ApiResponse.error("Record not found"));
    }
    
    @DeleteMapping("/deletename/{id}")
    public ApiResponse<Void> deleteAnimateUser(@PathVariable Integer id) {
        return animateUserService.findById(id)
                .map(animateUser -> {
                    animateUserService.deleteById(id);
                    return ApiResponse.<Void>success(null);
                })
                .orElse(ApiResponse.error("Record not found"));
    }
} 