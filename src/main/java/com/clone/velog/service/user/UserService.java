package com.clone.velog.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.entity.user.UserEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.UserReq;
import com.clone.velog.models.network.response.UserRes;
import com.clone.velog.repository.UserRepository;

@Service
public class UserService implements CrudInterface<UserReq, UserRes> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Header<UserRes> create(Header<UserReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<UserRes> update(Header<UserReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Header<UserRes> login(String id, String pw) throws Exception {
        Thread.sleep(300);
        return userRepository.findByUseridAndUserpw(id, pw)
                .map(user -> response(user))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음"));
    }

    // response
    private Header<UserRes> response(UserEntity user) {
        UserRes userRes = UserRes.builder()
                .id(user.getId())
                .userid(user.getUserid())
                .userpw(user.getUserpw())
                .name(user.getName())
                .nickName(user.getNickName())
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
                .build();
        return Header.OK(userRes);
    }

    private UserRes responseOnlyUser(UserEntity user) {
        UserRes userRes = UserRes.builder()
                .id(user.getId())
                .userid(user.getUserid())
                .userpw(user.getUserpw())
                .name(user.getName())
                .nickName(user.getNickName())
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
                .build();
        return userRes;
    }
}
