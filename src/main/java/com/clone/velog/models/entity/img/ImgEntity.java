package com.clone.velog.models.entity.img;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "img")
@EntityListeners(AuditingEntityListener.class)
public class ImgEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String orgNm;
    private String savedNm;
    private String savedPath;
}
