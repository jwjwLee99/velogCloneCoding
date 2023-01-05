package com.clone.velog.service.img;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.clone.velog.models.entity.img.ImgEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.ImgReq;
import com.clone.velog.models.network.response.ImgRes;
import com.clone.velog.repository.ImgRepository;

@Service
public class ImgService {

    private String dir = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\";
    File Folder = new File(dir);

    @Autowired
    private ImgRepository imgRepository;

    // 리스트 형식으로 변환
    public Header<List<Integer>> create(List<MultipartFile> imgList) throws Exception {
        List<Integer> returnData = new ArrayList<>();

        if (imgList.isEmpty()) {
            return Header.ERROROfNull();
        }

        for (int i = 0; i < imgList.size(); i++) {
            String originName = imgList.get(i).getOriginalFilename();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
            String current_date = simpleDateFormat.format(new Date());
            String extension = originName.substring(originName.lastIndexOf(".")).toLowerCase();

            if (extension.isEmpty()) {
                continue;
            }

            String savedName = current_date + extension;
            String savedPath = dir + savedName;

            Folder.mkdir();
            imgList.get(i).transferTo(new File(savedPath));

            ImgEntity imgSave = ImgEntity.builder()
                    .orgNm(originName)
                    .savedNm(savedName)
                    .savedPath(savedPath)
                    .build();

            ImgEntity save = imgRepository.save(imgSave);

            returnData.add(save.getId());
        }

        return Header.OK(returnData);
    }

    public Header<ImgRes> read(Integer id) {
        return imgRepository.findById(id)
                .map(img -> response(img))
                .orElseGet(() -> Header.ERROR("No data"));
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
