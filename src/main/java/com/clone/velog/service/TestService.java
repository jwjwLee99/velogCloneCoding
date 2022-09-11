package com.clone.velog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clone.velog.models.TestModels;
import com.clone.velog.repository.CrudInterface;
import com.clone.velog.repository.TestRepository;

import lombok.RequiredArgsConstructor;

// 임시 생성 파일, Service 관련 폴더
// 데이터 처리 로직
// 직접 데이터 베이스에 접근하는 로직 처리
@Service
@RequiredArgsConstructor
public class TestService implements CrudInterface {
    
    private TestRepository testRepository;

    
    public List<TestModels> getAll() {
        List<TestModels> data = testRepository.findAll();
    
        return data;
    }

    @Override
    public int create(TestModels testEntity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(TestModels testEntity) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TestModels read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

}
