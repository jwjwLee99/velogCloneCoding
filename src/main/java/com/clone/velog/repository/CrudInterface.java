package com.clone.velog.repository;

import com.clone.velog.models.TestModels;

public interface CrudInterface {
    public int create(TestModels testDTO);
    public TestModels read(Integer id);
    public int update(TestModels testDTO);
    public int delete(Integer id);   
}
