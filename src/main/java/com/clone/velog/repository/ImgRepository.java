package com.clone.velog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.velog.models.entity.img.ImgEntity;

@Repository
public interface ImgRepository extends JpaRepository<ImgEntity, Integer> {

}
