package com.clone.velog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.velog.models.entity.img.ImgEntity;

public interface ImgRepository extends JpaRepository<ImgEntity, Integer> {

}
