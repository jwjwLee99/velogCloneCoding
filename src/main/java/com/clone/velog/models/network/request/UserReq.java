package com.clone.velog.models.network.request;

import java.time.LocalDateTime;
import java.util.List;

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
    @CreatedDate
    private LocalDateTime regdate;

    private List<Integer> imgId;

    public UserEntity toEntity() {
        UserEntity build = UserEntity.builder()
                .id(id)
                .userid(userid)
                .userpw(userpw)
                .name(name)
                .nickName(nickName)
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
