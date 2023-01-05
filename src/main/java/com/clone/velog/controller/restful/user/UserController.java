package com.clone.velog.controller.restful.user;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.UserReq;
import com.clone.velog.models.network.response.UserRes;
import com.clone.velog.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController implements CrudInterface<UserReq, UserRes> {

    private final UserService userservice;

    @Override
    @PostMapping(value = "", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Header<UserRes> create(
            @RequestBody Header<UserReq> request) {
        return userservice.create(request);
    }

    @Override
    public Header<UserRes> read(Integer id) {
        return userservice.read(id);
    }

    @Override
    public Header<UserRes> update(Header<UserReq> request) {
        return userservice.update(request);
    }

    @Override
    public Header delete(Integer id) {
        return userservice.delete(id);
    }

    // 로그인
    @GetMapping("/login/{userid}")
    public Header<UserRes> login(@PathVariable("userid") String id)
            throws Exception {
        return userservice.login(id);
    }

}
