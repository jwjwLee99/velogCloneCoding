package com.clone.velog.service.img;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.clone.velog.models.entity.img.ImgEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.ImgReq;
import com.clone.velog.models.network.response.ImgRes;
import com.clone.velog.repository.ImgRepository;

public class ImgService {

    @Value("${file.dir}")
    private String dir;

    private ImgRepository imgRepository;

    public Integer create(MultipartFile img) throws IllegalStateException, IOException {
        if (img.isEmpty()) {
            return null;
        }

        String originName = img.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();

        String extension = originName.substring(originName.lastIndexOf("."));

        String savedName = uuid + extension;

        String savedPath = dir + savedName;

        ImgEntity imgSave = ImgEntity.builder()
                .orgNm(originName)
                .savedNm(savedName)
                .savedPath(savedPath)
                .build();

        img.transferTo(new File(savedPath));

        ImgEntity save = imgRepository.save(imgSave);

        return save.getId();
    }

    public Header<ImgRes> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Header<ImgRes> update(Header<ImgReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    public Header delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    private Header<ImgRes> response(ImgEntity img) {
        ImgRes imgRes = ImgRes.builder()
                .id(img.getId())
                .orgNm(img.getOrgNm())
                .savedNm(img.getSavedNm())
                .savedPath(img.getSavedPath())
                .build();

        return Header.OK(imgRes);
    }

}
