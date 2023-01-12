package com.clone.velog.controller.restful.post;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.PostReq;
import com.clone.velog.models.network.response.PostRes;
import com.clone.velog.service.post.PostService;

import lombok.RequiredArgsConstructor;

// Restful API 작동하는 Controller
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController implements CrudInterface<PostReq, PostRes> {
    
    public final PostService postService;

    @Override
    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Header<PostRes> create(
            @RequestBody Header<PostReq> request) {
        return postService.create(request);
    }

    @Override
    @GetMapping(value = "/{postIndex}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Header<PostRes> read(@PathVariable("postIndex") Integer postIndex) {
        return postService.read(postIndex);
    }

    @Override
    @PostMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Header<PostRes> update(@RequestBody Header<PostReq> request) {
        return postService.update(request);
    }

    @Override
    @DeleteMapping(value = "/{postIndex}")
    public Header delete(@PathVariable("postIndex") Integer postIndex) {
        return postService.delete(postIndex);
    }

    public Header<List<PostRes>> list(){
        return null;
    }
    
}
