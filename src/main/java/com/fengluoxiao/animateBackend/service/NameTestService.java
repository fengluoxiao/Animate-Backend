package com.fengluoxiao.animateBackend.service;

import com.fengluoxiao.animateBackend.model.NameTest;
import java.util.List;
import java.util.Optional;

public interface NameTestService {
    List<NameTest> findAll();
    Optional<NameTest> findById(Integer id);
    NameTest save(NameTest nameTest);
    void deleteById(Integer id);
    NameTest update(NameTest nameTest);
} 