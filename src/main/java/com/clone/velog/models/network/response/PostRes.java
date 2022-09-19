package com.clone.velog.models.network.response;

import java.time.LocalDateTime;

import com.clone.velog.models.enm.PostTemp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRes {
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
