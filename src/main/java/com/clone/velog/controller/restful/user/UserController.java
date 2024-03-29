package com.clone.velog.controller.restful.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @PostMapping(value = "")
    public Header<UserRes> create(@RequestBody Header<UserReq> request) {
        return userservice.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public Header<UserRes> read(@PathVariable Integer id) {
        return userservice.read(id);
    }

    @Override
    @PutMapping("/{id}")
    public Header<UserRes> update(@RequestBody Header<UserReq> request) {
        return userservice.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public Header delete(@PathVariable Integer id) {
        return userservice.delete(id);
    }

    // 로그인
    @GetMapping("/login/{userid}")
    public Header<UserRes> login(@PathVariable("userid") String id)
            throws Exception {
        return userservice.login(id);
    }

}
