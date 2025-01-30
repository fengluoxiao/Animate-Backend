package com.fengluoxiao.animateBackend.service;

import com.fengluoxiao.animateBackend.model.AnimateUser;
import java.util.List;
import java.util.Optional;

public interface AnimateUserService {
    List<AnimateUser> findAll();
    Optional<AnimateUser> findById(Integer id);
    AnimateUser save(AnimateUser animateUser);
    void deleteById(Integer id);
    AnimateUser update(AnimateUser animateUser);
} 