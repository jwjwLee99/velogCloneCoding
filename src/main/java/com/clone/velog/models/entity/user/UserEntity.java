package com.clone.velog.models.entity.user;

import java.time.LocalDateTime;
import java.util.List;

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
@Entity(name = "user")
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String userid;
    private String userpw;
    private String name;
    private String nickName;
    private String hp;
    private String title;
    private String descript;
    private String email;
    private String git;
    private String twitter;
    private String facebook;
    private String homePage;
    private String isAggreeEmail;
    private String isAggreeUpdate;
    private LocalDateTime regdate;

    private List<Integer> imgId;
}
