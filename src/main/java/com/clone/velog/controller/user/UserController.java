package com.clone.velog.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clone.velog.models.user.UserEntity;
import com.clone.velog.repository.CrudInterface;
import com.clone.velog.service.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController implements CrudInterface {
    @Autowired
    private UserService userService;

    // 게시물 등록
    @PostMapping("createPost")
    public String create(UserEntity userModel) {
        // TODO Auto-generated method stub
        return null;
    }

    // 게시물 삭제
    @Override
    @DeleteMapping("deletePost")
    public String delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }


    // 게시물 업데이트
    @PutMapping("updatePost")
    public String update(UserEntity userModel) {
        // TODO Auto-generated method stub
        return null;
    }

    // 게시물 상세내용
    @GetMapping("{id}")
    public String read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    // 게시물 전체목록
    @GetMapping("")
    public String getAll(){
        return null;
    }
}
