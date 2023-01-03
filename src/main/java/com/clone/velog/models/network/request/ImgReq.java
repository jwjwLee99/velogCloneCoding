package com.clone.velog.models.network.request;

import com.clone.velog.models.entity.img.ImgEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgReq {
    private Integer id;
    private String orgNm;
    private String savedNm;
    private String savedPath;

    public ImgEntity toEntity() {
        ImgEntity build = ImgEntity.builder()
                .id(id)
                .orgNm(orgNm)
                .savedNm(savedNm)
                .savedPath(savedPath)
                .build();

        return build;
    }
}
