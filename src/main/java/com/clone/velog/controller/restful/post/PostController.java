package com.clone.velog.controller.restful.post;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.PostReq;
import com.clone.velog.models.network.response.PostRes;

import lombok.RequiredArgsConstructor;

// Restful API 작동하는 Controller
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PostController implements CrudInterface<PostReq, PostRes> {
    
    @Override
    public Header<PostRes> create(Header<PostReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<PostRes> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<PostRes> update(Header<PostReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Header<List<PostRes>> list(){
        return null;
    }
    
}
