package com.clone.velog.controller.restful.img;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.velog.service.img.ImgService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/img")
@RequiredArgsConstructor
public class ImgController {
    private ImgService imgService;
}
