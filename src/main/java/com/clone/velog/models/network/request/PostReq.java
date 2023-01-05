package com.clone.velog.models.network.request;

import java.time.LocalDateTime;

import com.clone.velog.models.enm.PostTemp;
import com.clone.velog.models.entity.post.PostEntity;
import com.clone.velog.models.entity.post.PostEntity.PostEntityBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostReq {
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
    
    public PostEntity toEntity() {
        PostEntity build = PostEntity.builder()
                .postIndex(postIndex)
                .postTitle(postTitle)
                .postDescription(postDescription)
                .postImgName(postImgName)
                .postImgOriName(postImgOriName)
                .postImgURL(postImgURL)
                .postTempSave(postTempSave)
                .postRegDate(postRegDate)
                .postUpdateDate(postUpdateDate)
                .postTag(postTag)
                .postHits(postHits)
                .postLove(postLove)
                .build();

        return build;
    }
}
