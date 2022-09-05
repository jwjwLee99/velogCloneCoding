package com.clone.velog.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 임시 생성 파일, DTO 관련 폴더
// Data Transfer Object
// RestfulController
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name ="test")
@EntityListeners(AuditingEntityListener.class)
public class TestDTO {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    @CreatedDate
    private LocalDateTime regdate;
}
