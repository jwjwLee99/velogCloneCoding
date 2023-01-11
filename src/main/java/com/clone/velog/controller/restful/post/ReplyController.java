package com.clone.velog.controller.restful.post;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.ReplyReq;
import com.clone.velog.models.network.response.ReplyRes;
import com.clone.velog.service.post.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyController implements CrudInterface<ReplyReq, ReplyRes> {

    public final ReplyService replyService;

    @Override
    @PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Header<ReplyRes> create(
            @RequestBody Header<ReplyReq> request) {
        return replyService.create(request);
    }

    @Override
    public Header<ReplyRes> read(Integer id) {
        return null;
    }
    
    @GetMapping(value = "/{postIndex}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Header<List<ReplyRes>> readreply(@PathVariable("postIndex") Integer replyPostIndex) {
        
        return replyService.readList(replyPostIndex);
    }

    @Override
    public Header<ReplyRes> update(Header<ReplyReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
