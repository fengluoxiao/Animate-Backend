package com.fengluoxiao.animateBackend.dao;

import com.fengluoxiao.animateBackend.model.AnimateUser;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AnimateUserMapper {
    List<AnimateUser> findAll();
    AnimateUser findById(Integer id);
    int insert(AnimateUser animateUser);
    int update(AnimateUser animateUser);
    int deleteById(Integer id);
} 