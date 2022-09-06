package com.clone.velog.repository;

import com.clone.velog.entity.TestEntity;

public interface CrudInterface {
    public int create(TestEntity testDTO);
    public TestEntity read(Integer id);
    public int update(TestEntity testDTO);
    public int delete(Integer id);   
}
