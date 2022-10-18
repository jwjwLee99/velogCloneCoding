package com.clone.velog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.velog.models.entity.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
