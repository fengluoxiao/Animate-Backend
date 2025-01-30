package com.fengluoxiao.animateBackend.service.impl;

import com.fengluoxiao.animateBackend.dao.AnimateUserMapper;
import com.fengluoxiao.animateBackend.model.AnimateUser;
import com.fengluoxiao.animateBackend.service.AnimateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimateUserServiceImpl implements AnimateUserService {
    
    @Autowired
    private AnimateUserMapper adminUserMapper;
    
    @Override
    public List<AnimateUser> findAll() {
        return adminUserMapper.findAll();
    }
    
    @Override
    public Optional<AnimateUser> findById(Integer id) {
        return Optional.ofNullable(adminUserMapper.findById(id));
    }
    
    @Override
    public AnimateUser save(AnimateUser adminUser) {
        adminUserMapper.insert(adminUser);
        return adminUser;
    }
    
    @Override
    public void deleteById(Integer id) {
        adminUserMapper.deleteById(id);
    }
    
    @Override
    public AnimateUser update(AnimateUser adminUser) {
        adminUserMapper.update(adminUser);
        return adminUser;
    }
} 