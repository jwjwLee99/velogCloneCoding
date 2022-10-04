package com.clone.velog.models.entity.post;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.clone.velog.models.enm.PostTemp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "post")
@EntityListeners(AuditingEntityListener.class)
public class PostEntity {

    @Id
    @GeneratedValue
    private int postIndex;
    private String postTitle;
    private String postDescription;
    private String postImgName;
    private String postImgOriName;
    private String postImgURL;
    private PostTemp postTempSave;
    private LocalDateTime postRegDate;
    private LocalDateTime postUpdateDate;
    private String postTag;
    private int postHits;
    private int postLove;
    
    // 참조 인덱스
    private int postUserIndex;
    private int SeriesIndex;
    
}
