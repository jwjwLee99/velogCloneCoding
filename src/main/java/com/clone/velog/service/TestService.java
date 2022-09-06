package com.clone.velog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clone.velog.dto.TestDTO;
import com.clone.velog.repository.CrudInterface;
import com.clone.velog.repository.TestRepository;

import lombok.RequiredArgsConstructor;

// 임시 생성 파일, Service 관련 폴더
// 데이터 처리 로직
@Service
@RequiredArgsConstructor
public class TestService implements CrudInterface {
    
    private final TestRepository testRepository;

    
    public List<TestDTO> getAll() {
        List<TestDTO> data = testRepository.findAll();
    
        return data;
    }

    @Override
    public int create(TestDTO testDTO) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(TestDTO testDTO) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TestDTO read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

}
