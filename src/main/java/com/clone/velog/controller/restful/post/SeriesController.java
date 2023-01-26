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

    @Override
    public Header<SeriesRes> read(Integer id) {
        return null;
    }

    // 시리즈 목록
    @GetMapping(value = "/List", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Header<List<SeriesRes>> readSeriesList() {
        return seriesService.readSeriesList();
    }

    //시리즈 게시글 목록
    @GetMapping(value = "/List/{seriesIndex}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Header<SeriesRes> seriesPostList(@PathVariable("seriesIndex") Integer seriesIndex) {
        return seriesService.seriesPostList(seriesIndex);
    }
  

    // seriesIndex 키 값 확인해서 변경
    // postman에서 seriesIndex 값을 지정해서 변경함
    @Override
    @PostMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Header<SeriesRes> update(@RequestBody Header<SeriesReq> request) {
        return seriesService.update(request);
    }

    @Override
    @DeleteMapping(value = "/delete/{seriesIndex}")
    public Header delete(@PathVariable("seriesIndex") Integer seriesIndex) {
        return seriesService.delete(seriesIndex);
    }
    
}