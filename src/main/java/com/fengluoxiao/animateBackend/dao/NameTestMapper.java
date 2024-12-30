package com.fengluoxiao.animateBackend.dao;

import com.fengluoxiao.animateBackend.model.NameTest;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NameTestMapper {
    List<NameTest> findAll();
    NameTest findById(Integer id);
    int insert(NameTest nameTest);
    int update(NameTest nameTest);
    int deleteById(Integer id);
} 