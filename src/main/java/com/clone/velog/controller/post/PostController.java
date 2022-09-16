package com.clone.velog.controller.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clone.velog.models.post.PostEntity;
import com.clone.velog.repository.CrudInterface;
import com.clone.velog.service.post.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController implements CrudInterface{
    
    @Autowired
    private PostService postService;

    // 게시물 등록
    @PostMapping("createPost")
    public String create(PostEntity postModel) {
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
    public String update(PostEntity postModel) {
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
