package com.fengluoxiao.animateAdminBackend.dao;

import com.fengluoxiao.animateAdminBackend.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin findByUsername(String username);
    int insert(Admin admin);
    int update(Admin admin);
    int deleteById(Integer id);
    long countAdmins();
} 