package com.clone.velog.models.network.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeriesRes {
    private int seriesIndex;
    private String seriesTitle;
    private LocalDateTime seriesRegData;
    private LocalDateTime seriesUpdateDate;
    private int seriesCount;
    private int seriesUserIndex;
}