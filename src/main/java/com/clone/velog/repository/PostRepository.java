package com.clone.velog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.velog.models.entity.post.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    
}
