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
public class ReplyRes {
    private int replyIndex;
    private String replyDescription;
    private LocalDateTime replyRegdate;
    private LocalDateTime replyUpdateDate;
    private int replyUserIndex;
    private int replyPostIndex;
}
