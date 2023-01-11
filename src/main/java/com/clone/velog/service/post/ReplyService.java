package com.clone.velog.service.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.entity.post.ReplyEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.ReplyReq;
import com.clone.velog.models.network.response.ReplyRes;
import com.clone.velog.repository.ReplyRepository;

@Service
public class ReplyService implements CrudInterface<ReplyReq, ReplyRes> {

    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public Header<ReplyRes> create(Header<ReplyReq> request) {
        return response(replyRepository.save(request.getData().toEntity()));
    }

    private Header<ReplyRes> response(ReplyEntity reply) {
        ReplyRes replyRes = ReplyRes.builder()
                .replyIndex(reply.getReplyIndex())
                .replyDescription(reply.getReplyDescription())
                .replyRegdate(reply.getReplyRegdate())
                .replyUpdateDate(reply.getReplyRegdate())
                .replyUserIndex(reply.getReplyUserIndex())
                .replyPostIndex(reply.getReplyPostIndex())
                .build();
        return Header.OK(replyRes);
    }

    @Override
    public Header<ReplyRes> read(Integer replyPostIndex) {
        return null;
    }

    // 댓글 목록 메서드 --> replyPostIndex받아오는게 안됨 내일 다시 해보기
    public Header<List<ReplyRes>> readList(Integer replyPostIndex) {
        // Optional<ReplyEntity> replypostIndex = replyRepository.findById(replyPostIndex);
        // if(replypostIndex.isEmpty()){
        //     return Header.ERROR("안되는거야 시발아");
        // }
        List<ReplyEntity> replyEntities = replyRepository.findAll();
        List<ReplyRes> replyList = new ArrayList<>();

        if (/*replypostIndex.get() != null*/replyPostIndex == 1) {
            for (ReplyEntity replyEntity : replyEntities) {
                ReplyRes replyRes = ReplyRes.builder()
                        .replyIndex(replyEntity.getReplyIndex())
                        .replyDescription(replyEntity.getReplyDescription())
                        .replyRegdate(replyEntity.getReplyRegdate())
                        .replyUpdateDate(replyEntity.getReplyRegdate())
                        .replyUserIndex(replyEntity.getReplyUserIndex())
                        .replyPostIndex(replyEntity.getReplyPostIndex())
                        .build();

                        replyList.add(replyRes);
            }
            return Header.OK(replyList);
        }
        else return Header.ERROR("No Data");
        
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
