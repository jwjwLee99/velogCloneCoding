package com.clone.velog.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.entity.user.UserEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.UserReq;
import com.clone.velog.models.network.response.UserRes;
import com.clone.velog.repository.UserRepository;
import com.clone.velog.service.img.ImgService;

@Service
public class UserService implements CrudInterface<UserReq, UserRes> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImgService imgService;

    @Override
    public Header<UserRes> create(Header<UserReq> request) {
        return response(userRepository.save(request.getData().toEntity()));
    }

    @Override
    public Header<UserRes> read(Integer id) {
        return userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(() -> Header.ERROR("No Data"));
    }

    @Override
    public Header<UserRes> update(Header<UserReq> request) {
        UserReq userReq = request.getData();
        Optional<UserEntity> user = userRepository.findById(userReq.getId());

        return user.map(member -> {
            member.setUserid(userReq.getUserid());
            member.setUserpw(userReq.getUserpw());
            member.setName(userReq.getName());
            member.setNickname(userReq.getNickname());
            member.setHp(userReq.getHp());
            member.setTitle(userReq.getTitle());
            member.setDescript(userReq.getDescript());
            member.setEmail(userReq.getEmail());
            member.setGit(userReq.getGit());
            member.setTwitter(userReq.getTwitter());
            member.setFacebook(userReq.getFacebook());
            member.setHomePage(userReq.getHomePage());
            member.setIsAggreeEmail(userReq.getIsAggreeEmail());
            member.setIsAggreeUpdate(userReq.getIsAggreeUpdate());

            return member;
        })
                .map(member -> userRepository.save(member))
                .map(member -> response(member))
                .orElseGet(() -> Header.ERROR("No Data"));
    }

    @Override
    public Header delete(Integer id) {
        Optional<UserEntity> user = userRepository.findById(id);

        return user.map(
                member -> {
                    userRepository.delete(member);
                    return Header.OK();
                }).orElseGet(() -> Header.ERROR("No Data"));
    }

    // login
    public Header<UserRes> login(String id) throws Exception {
        Thread.sleep(300);
        return userRepository.findByUserid(id)
                .map(user -> response(user))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음"));
    }

    // 사용자 이미지 수정
    /*
     * 이미지의 인덱스를 담은 리스트를 반환
     * null값 반환시 기본 이미지로 전환
     */
    public Header<List<Integer>> updateProfileImg(Header<List<MultipartFile>> img) throws Exception {
        if (img.getData().isEmpty()) {
            return Header.ERROROfNull();
        }
        return imgService.create(img.getData());
    }

    // response
    private Header<UserRes> response(UserEntity user) {
        UserRes userRes = UserRes.builder()
                .id(user.getId())
                .userid(user.getUserid())
                .userpw(user.getUserpw())
                .name(user.getName())
                .nickname(user.getNickname())
                .hp(user.getHp())
                .title(user.getTitle())
                .descript(user.getDescript())
                .email(user.getEmail())
                .git(user.getGit())
                .twitter(user.getTwitter())
                .facebook(user.getFacebook())
                .homePage(user.getHomePage())
                .isAggreeEmail(user.getIsAggreeEmail())
                .isAggreeUpdate(user.getIsAggreeUpdate())
                .regdate(user.getRegdate())
                .imgId(user.getImgId())
                .build();
        return Header.OK(userRes);
    }

    private UserRes responseOnlyUser(UserEntity user) {
        UserRes userRes = UserRes.builder()
                .id(user.getId())
                .userid(user.getUserid())
                .userpw(user.getUserpw())
                .name(user.getName())
                .nickname(user.getNickname())
                .hp(user.getHp())
                .title(user.getTitle())
                .descript(user.getDescript())
                .email(user.getEmail())
                .git(user.getGit())
                .twitter(user.getTwitter())
                .facebook(user.getFacebook())
                .homePage(user.getHomePage())
                .isAggreeEmail(user.getIsAggreeEmail())
                .isAggreeUpdate(user.getIsAggreeUpdate())
                .regdate(user.getRegdate())
                .imgId(user.getImgId().toString())
                .build();
        return userRes;
    }
}
