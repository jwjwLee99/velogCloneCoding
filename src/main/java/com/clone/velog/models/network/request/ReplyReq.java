package com.clone.velog.models.network.request;

import java.time.LocalDateTime;

import com.clone.velog.models.entity.post.ReplyEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyReq {
    private int replyIndex;
    private String replyDescription;
    private LocalDateTime replyRegdate;
    private LocalDateTime replyUpdateDate;
    private int replyUserIndex;
    private int replyPostIndex;

    public ReplyEntity toEntity() {
        ReplyEntity build = ReplyEntity.builder()
            .replyIndex(replyIndex)
            .replyDescription(replyDescription)
            .replyRegdate(replyRegdate)
            .replyUpdatedate(replyUpdateDate)
            .replyUserIndex(replyUserIndex)
            .replyPostIndex(replyPostIndex)
            .build();

            return build;
    }
}
