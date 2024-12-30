package com.fengluoxiao.animateBackend.service.impl;

import com.fengluoxiao.animateBackend.dao.NameTestMapper;
import com.fengluoxiao.animateBackend.model.NameTest;
import com.fengluoxiao.animateBackend.service.NameTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameTestServiceImpl implements NameTestService {
    
    @Autowired
    private NameTestMapper nameTestMapper;
    
    @Override
    public List<NameTest> findAll() {
        return nameTestMapper.findAll();
    }
    
    @Override
    public Optional<NameTest> findById(Integer id) {
        return Optional.ofNullable(nameTestMapper.findById(id));
    }
    
    @Override
    public NameTest save(NameTest nameTest) {
        nameTestMapper.insert(nameTest);
        return nameTest;
    }
    
    @Override
    public void deleteById(Integer id) {
        nameTestMapper.deleteById(id);
    }
    
    @Override
    public NameTest update(NameTest nameTest) {
        nameTestMapper.update(nameTest);
        return nameTest;
    }
} 