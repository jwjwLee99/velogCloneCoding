package com.clone.velog.controller.restful.img;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.response.ImgRes;
import com.clone.velog.service.img.ImgService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/img")
@RequiredArgsConstructor
public class ImgController {

    @Autowired
    private ImgService imgService;

    @PostMapping(value = "/save/list", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    private Header<List<Integer>> create(@RequestParam("files") List<MultipartFile> files) throws Exception {
        return imgService.create(files);
    }

    @GetMapping("/{id}")
    private Header<ImgRes> read(@PathVariable Integer id) {
        return imgService.read(id);
    }
}
