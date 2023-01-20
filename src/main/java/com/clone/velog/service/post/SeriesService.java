package com.clone.velog.service.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.entity.post.SeriesEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.SeriesReq;
import com.clone.velog.models.network.response.SeriesRes;
import com.clone.velog.repository.SeriesRepository;

@Service
public class SeriesService implements CrudInterface<SeriesReq, SeriesRes> {

    @Autowired
    private SeriesRepository seriesRepository;

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

    public Header<List<SeriesRes>> readSeriesList() {
        List<SeriesEntity> seriesEntities = seriesRepository.findAll();
        List<SeriesRes> seriesList = new ArrayList<>();

        for (SeriesEntity seriesEntity : seriesEntities) {
            SeriesRes seriesRes = SeriesRes.builder() 
<<<<<<< HEAD
                    .seriesIndex(seriesEntity.getSeriesIndex())
                    .seriesTitle(seriesEntity.getSeriesTitle())
                    .seriesRegData(seriesEntity.getSeriesRegData())
                    .seriesUpdateDate(seriesEntity.getSeriesUpdateDate())
                    .seriesCount(seriesEntity.getSeriesCount())
                    .seriesUserIndex(seriesEntity.getSeriesUserIndex())
                    .build();

                    seriesList.add(seriesRes);
=======
                   .seriesIndex(seriesEntity.getSeriesIndex())
                   .seriesTitle(seriesEntity.getSeriesTitle())
                   .seriesRegData(seriesEntity.getSeriesRegData())
                   .seriesUpdateDate(seriesEntity.getSeriesUpdateDate())
                   .seriesCount(seriesEntity.getSeriesCount())
                   .seriesUserIndex(seriesEntity.getSeriesUserIndex())
                   .build();

                   seriesList.add(seriesRes);
>>>>>>> 41e34bc (series method update)
            }
            return Header.OK(seriesList);
    }

    //해야 됨
    public Header<SeriesRes> seriesPostList(Integer seriesIndex) {
        return null;
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
