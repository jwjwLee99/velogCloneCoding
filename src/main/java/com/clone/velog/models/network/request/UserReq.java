package com.clone.velog.models.network.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReq {
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
}
