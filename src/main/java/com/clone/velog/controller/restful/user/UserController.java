package com.clone.velog.controller.restful.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class UserController implements CrudInterface<UserReq, UserRes>{
    
    private final UserService userservice;
    
    @Override
    public Header<UserRes> create(Header<UserReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String delete(Integer id) {
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

    // 로그인
    @GetMapping("/login/{id}")
    public Header<UserRes> login(@PathVariable(name = "id")String id) throws Exception{
        return userservice.login(id);
    }

}
