package com.fengluoxiao.animateAdminBackend.model;

public class Admin {
    private Integer id;
    private String username;
    private String password;

    // 构造函数
    public Admin() {}

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='[PROTECTED]'" +
                '}';
    }
} 