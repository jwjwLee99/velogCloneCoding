package com.clone.velog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.velog.dto.TestDTO;

// 임시 생성 파일, interface 관련 폴더
// ex) JpaRepository
@Repository
public interface TestRepository extends JpaRepository<TestDTO, Integer> {
    
}
