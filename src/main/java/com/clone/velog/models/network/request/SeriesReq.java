package com.clone.velog.models.network.request;

import java.time.LocalDateTime;

import com.clone.velog.models.entity.post.SeriesEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesReq {
    private int seriesIndex;
    private String seriesTitle;
    private LocalDateTime seriesRegData;
    private LocalDateTime seriesUpdateDate;
    private int seriesCount;
    private int seriesUserIndex;

    public SeriesEntity toEntity() {
        SeriesEntity build = SeriesEntity.builder()
            .seriesIndex(seriesIndex)
            .seriesTitle(seriesTitle)
            .seriesRegData(seriesRegData)
            .seriesUpdateDate(seriesUpdateDate)
            .seriesCount(seriesCount)
            .seriesUserIndex(seriesUserIndex)
            .build();
    
        return build;
    }          
}
