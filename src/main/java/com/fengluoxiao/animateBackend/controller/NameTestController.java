package com.fengluoxiao.animateBackend.controller;

import com.fengluoxiao.animateBackend.model.ApiResponse;
import com.fengluoxiao.animateBackend.model.NameTest;
import com.fengluoxiao.animateBackend.service.NameTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class NameTestController {
    
    @Autowired
    private NameTestService nameTestService;
    
    @GetMapping("/getallname")
    public ApiResponse<List<NameTest>> getAllNameTests() {
        return ApiResponse.success(nameTestService.findAll());
    }
    
    @GetMapping("/getname/{id}")
    public ApiResponse<NameTest> getNameTestById(@PathVariable Integer id) {
        return nameTestService.findById(id)
                .map(ApiResponse::success)
                .orElse(ApiResponse.error("Record not found"));
    }
    
    @PostMapping("/createname")
    public ApiResponse<NameTest> createNameTest(@RequestBody NameTest nameTest) {
        try {
            return ApiResponse.success(nameTestService.save(nameTest));
        } catch (Exception e) {
            return ApiResponse.error("Failed to create record: " + e.getMessage());
        }
    }
    
    @PutMapping("/updatename/{id}")
    public ApiResponse<NameTest> updateNameTest(@PathVariable Integer id, @RequestBody NameTest nameTest) {
        return nameTestService.findById(id)
                .map(existingNameTest -> {
                    nameTest.setId(id);
                    return ApiResponse.success(nameTestService.update(nameTest));
                })
                .orElse(ApiResponse.error("Record not found"));
    }
    
    @DeleteMapping("/deletename/{id}")
    public ApiResponse<Void> deleteNameTest(@PathVariable Integer id) {
        return nameTestService.findById(id)
                .map(nameTest -> {
                    nameTestService.deleteById(id);
                    return ApiResponse.<Void>success(null);
                })
                .orElse(ApiResponse.error("Record not found"));
    }
} 