package com.clone.velog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.velog.models.entity.post.ReplyEntity;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {
    
}
