package com.clone.velog.service.post;

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
        // TODO Auto-generated method stub
        return null;
    }

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
