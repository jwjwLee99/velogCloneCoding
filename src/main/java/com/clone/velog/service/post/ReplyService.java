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

    // 댓글 목록 메서드
    public Header<List<ReplyRes>> readList(Integer replyPostIndex) {
        List<ReplyEntity> replyEntities = replyRepository.findByreplyPostIndex(replyPostIndex);
        List<ReplyRes> replyList = new ArrayList<>();

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

    @Override
    public Header<ReplyRes> update(Header<ReplyReq> request) {
        ReplyReq replyReq = request.getData();
        Optional<ReplyEntity> replyIndex = replyRepository.findById(replyReq.getReplyIndex());

        return replyIndex.map(reply -> {
            reply.setReplyIndex(replyReq.getReplyIndex());
            reply.setReplyDescription(replyReq.getReplyDescription());
            reply.setReplyRegdate(replyReq.getReplyRegdate());
            reply.setReplyUpdatedate(replyReq.getReplyUpdateDate());
            reply.setReplyUserIndex(replyReq.getReplyUserIndex());
            reply.setReplyPostIndex(replyReq.getReplyPostIndex());

            return reply;
        })
                .map(reply -> replyRepository.save(reply))
                .map(reply -> response(reply))
                .orElseGet(() -> Header.ERROR("No difference"));
    }

    @Override
    public Header delete(Integer replyIndex) {
        Optional<ReplyEntity> ReplyIndex = replyRepository.findById(replyIndex);

        return ReplyIndex.map(
            ReplyRes -> {
                replyRepository.delete(ReplyRes);
                return Header.OK();
            }).orElseGet(() -> Header.ERROR(" No data"));
    }

}
