package com.clone.velog.models.network.request;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.clone.velog.models.entity.user.UserEntity;

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
    private String nickname;
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
    @CreatedDate
    private LocalDateTime regdate;

    private String imgId;

    public UserEntity toEntity() {
        UserEntity build = UserEntity.builder()
                .id(id)
                .userid(userid)
                .userpw(userpw)
                .name(name)
                .nickname(nickname)
                .hp(hp)
                .title(title)
                .descript(descript)
                .email(email)
                .git(git)
                .twitter(twitter)
                .facebook(facebook)
                .homePage(homePage)
                .isAggreeEmail(isAggreeEmail)
                .isAggreeUpdate(isAggreeUpdate)
                .regdate(regdate)
                .imgId(imgId)
                .build();

        return build;
    }
}
