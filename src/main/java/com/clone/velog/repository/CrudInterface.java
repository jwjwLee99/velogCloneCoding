package com.clone.velog.repository;

import com.clone.velog.dto.TestDTO;

public interface CrudInterface {
    public int create(TestDTO testDTO);
    public TestDTO read(Integer id);
    public int update(TestDTO testDTO);
    public int delete(Integer id);   
}
