package com.clone.velog.models.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgRes {
    private Integer id;
    private String orgNm;
    private String savedNm;
    private String savedPath;
}
