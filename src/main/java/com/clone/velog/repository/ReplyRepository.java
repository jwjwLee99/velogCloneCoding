package com.clone.velog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.velog.models.entity.post.ReplyEntity;
import com.clone.velog.models.network.request.ReplyReq;
import com.clone.velog.models.network.response.ReplyRes;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer>{
    List<ReplyEntity> findByreplyPostIndex(Integer replyPostIndex);
}
