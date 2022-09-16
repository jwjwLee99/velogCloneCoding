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
    private int userIndex;
    private String userName;
    private String userId;
    private String userPassword;
    private String userRrn;
    private String userHp;
    private String userEmail;
    private String userImgName;
    private String userImgOriName;
    private String userImgURL;
    private String userTitle;
    private String userDescription;
    private LocalDateTime userRegDate;
}
