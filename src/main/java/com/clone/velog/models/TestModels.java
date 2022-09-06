package com.clone.velog.models;

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

// 임시 생성 파일, Model 관련 폴더
// Database의 컬럼명와 일치되는 class 변수
// MVC 모델의 Models 부분
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name ="test")
@EntityListeners(AuditingEntityListener.class)
public class TestModels {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    @CreatedDate
    private LocalDateTime regdate;
}
