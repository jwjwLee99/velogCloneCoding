package com.clone.velog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clone.velog.entity.TestEntity;
import com.clone.velog.repository.CrudInterface;
import com.clone.velog.repository.TestRepository;

import lombok.RequiredArgsConstructor;

// 임시 생성 파일, Service 관련 폴더
// 데이터 처리 로직
@Service
@RequiredArgsConstructor
public class TestService implements CrudInterface {
    
    private final TestRepository testRepository;

    
    public List<TestEntity> getAll() {
        List<TestEntity> data = testRepository.findAll();
    
        return data;
    }

    @Override
    public int create(TestEntity testEntity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(TestEntity testEntity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TestEntity read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

}
