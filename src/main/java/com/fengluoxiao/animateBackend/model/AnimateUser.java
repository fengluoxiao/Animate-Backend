package com.fengluoxiao.animateBackend.model;

public class AnimateUser {
    private Integer id;
    private String username;
    private String password;
    private String desc;
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return username;
    }
    
    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    public void setId(String password) {
        this.password = password;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
} 