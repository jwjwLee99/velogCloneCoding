package com.clone.velog.service.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.entity.post.PostEntity;
import com.clone.velog.models.entity.post.SeriesEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.SeriesReq;
import com.clone.velog.models.network.response.PostRes;
import com.clone.velog.models.network.response.SeriesRes;
import com.clone.velog.repository.PostRepository;
import com.clone.velog.repository.SeriesRepository;

@Service
public class SeriesService implements CrudInterface<SeriesReq, SeriesRes> {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public Header<SeriesRes> create(Header<SeriesReq> request) {
        return response(seriesRepository.save(request.getData().toEntity()));
    }

    private Header<SeriesRes> response(SeriesEntity series) {
        SeriesRes seriesRes = SeriesRes.builder()
                    .seriesIndex(series.getSeriesIndex())
                    .seriesTitle(series.getSeriesTitle())
                    .seriesRegData(series.getSeriesRegData())
                    .seriesUpdateDate(series.getSeriesUpdateDate())
                    .seriesCount(series.getSeriesCount())
                    .seriesUserIndex(series.getSeriesUserIndex())
                    .build();
        return Header.OK(seriesRes);
    }

    @Override
    public Header<SeriesRes> read(Integer id) {
        return null;
    }

    // 시리즈 목록
    public Header<List<SeriesRes>> readSeriesList() {
        List<SeriesEntity> seriesEntities = seriesRepository.findAll();
        List<SeriesRes> seriesList = new ArrayList<>();

        for (SeriesEntity seriesEntity : seriesEntities) {
            SeriesRes seriesRes = SeriesRes.builder() 
                   .seriesIndex(seriesEntity.getSeriesIndex())
                   .seriesTitle(seriesEntity.getSeriesTitle())
                   .seriesRegData(seriesEntity.getSeriesRegData())
                   .seriesUpdateDate(seriesEntity.getSeriesUpdateDate())
                   .seriesCount(seriesEntity.getSeriesCount())
                   .seriesUserIndex(seriesEntity.getSeriesUserIndex())
                   .build();

                   seriesList.add(seriesRes);
            }
            return Header.OK(seriesList);
    }

    //시리즈 게시글 목록
    public Header<List<PostRes>> seriesPostList(Integer seriesIndex) {
        List<PostEntity> postEntities = postRepository.findBySeriesIndex(seriesIndex);
        List<PostRes> seriespostList = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            PostRes postRes = PostRes.builder()
                    .postIndex(postEntity.getPostIndex())
                    .postTitle(postEntity.getPostTitle())
                    .postDescription(postEntity.getPostDescription())
                    .postImgName(postEntity.getPostImgName())
                    .postImgURL(postEntity.getPostImgURL())
                    .postTempSave(postEntity.getPostTempSave())
                    .postRegDate(postEntity.getPostRegDate())
                    .postUpdateDate(postEntity.getPostUpdateDate())
                    .postTag(postEntity.getPostTag())
                    .postHits(postEntity.getPostHits())
                    .postLove(postEntity.getPostLove())
                    .postUserIndex(postEntity.getPostUserIndex())
                    .SeriesIndex(postEntity.getSeriesIndex())
                    .build();

                    seriespostList.add(postRes);
        }
        return Header.OK(seriespostList);
    }


    @Override
    public Header<SeriesRes> update(Header<SeriesReq> request) {
        SeriesReq seriesReq = request.getData();
        Optional<SeriesEntity> seriesIndex = seriesRepository.findById(seriesReq.getSeriesIndex());

        return seriesIndex.map(series -> {
            series.setSeriesIndex(seriesReq.getSeriesIndex());
            series.setSeriesTitle(seriesReq.getSeriesTitle());
            series.setSeriesRegData(seriesReq.getSeriesRegData());
            series.setSeriesUpdateDate(seriesReq.getSeriesUpdateDate());
            series.setSeriesCount(seriesReq.getSeriesCount());
            series.setSeriesUserIndex(seriesReq.getSeriesUserIndex());

            return series;
        })
                .map(series -> seriesRepository.save(series))
                .map(series -> response(series))
                .orElseGet(() -> Header.ERROR("No difference"));
    }

    @Override
    public Header delete(Integer seriesIndIndex) {
        Optional<SeriesEntity> seriesIndex = seriesRepository.findById(seriesIndIndex);
        return seriesIndex.map(
            SeriesRes -> {
                seriesRepository.delete(SeriesRes);
                return Header.OK();
            }).orElseGet(()-> Header.ERROR("No Data"));    
    }
    
}
