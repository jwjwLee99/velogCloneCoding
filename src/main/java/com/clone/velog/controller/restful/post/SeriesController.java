package com.clone.velog.controller.restful.post;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.SeriesReq;
import com.clone.velog.models.network.response.SeriesRes;
import com.clone.velog.service.post.SeriesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/series")
@RequiredArgsConstructor
public class SeriesController implements CrudInterface<SeriesReq, SeriesRes> {
    
    public final SeriesService seriesService;
    
    @Override
    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Header<SeriesRes> create(@RequestBody Header<SeriesReq> request) { 
        return seriesService.create(request);
    }

    // 시리즈 게시물 목록
    @Override
    public Header<SeriesRes> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    //시리즈 목록도 만들어야 됨    

    @Override
    public Header<SeriesRes> update(Header<SeriesReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
