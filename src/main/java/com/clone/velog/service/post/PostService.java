package com.clone.velog.service.post;

import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clone.velog.itf.CrudInterface;
import com.clone.velog.models.entity.post.PostEntity;
import com.clone.velog.models.network.Header;
import com.clone.velog.models.network.request.PostReq;
import com.clone.velog.models.network.response.PostRes;
import com.clone.velog.repository.PostRepository;
import com.clone.velog.service.img.ImgService;

@Service
public class PostService implements CrudInterface<PostReq, PostRes> {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ImgService imgService;

    @Override
    public Header<PostRes> create(Header<PostReq> request) {
        if(request.getData().getPostTitle() == null || request.getData().getPostDescription() == null || request.getData().getPostUserIndex() == 0){
            return Header.ERROROfNull();
        }
        return response(postRepository.save(request.getData().toEntity()));
    }

    private Header<PostRes> response(PostEntity post) {
        PostRes postRes = PostRes.builder()
                .postIndex(post.getPostIndex())
                .postTitle(post.getPostTitle())
                .postDescription(post.getPostDescription())
                .postImgName(post.getPostImgName())
                .postImgOriName(post.getPostImgOriName())
                .postImgURL(post.getPostImgURL())
                .postTempSave(post.getPostTempSave())
                .postRegDate(post.getPostRegDate())
                .postUpdateDate(post.getPostUpdateDate())
                .postTag(post.getPostTag())
                .postHits(post.getPostHits())
                .postLove(post.getPostLove())
                .postUserIndex(post.getPostUserIndex())
                .SeriesIndex(post.getSeriesIndex())
                .build();
        return Header.OK(postRes);
    }
    
    @Override
    public Header<PostRes> read(Integer postIndex) {
        
        Optional<PostEntity> post = postRepository.findBypostIndex(postIndex);
        if(post.isEmpty()){
            return Header.ERROROfNull();
        }
        PostEntity postEntity = post.get();
        
        return response(postEntity);
    }

    @Override
    public Header<PostRes> update(Header<PostReq> request) {
        PostReq postReq = request.getData(); 
        Optional<PostEntity> postId = postRepository.findById(postReq.getPostIndex());

        return postId.map(post -> {
            post.setPostIndex(postReq.getPostIndex());
            post.setPostTitle(postReq.getPostTitle());
            post.setPostDescription(postReq.getPostDescription());
            post.setPostImgName(postReq.getPostImgName());
            post.setPostImgOriName(postReq.getPostImgOriName());
            post.setPostImgURL(postReq.getPostImgURL());
            post.setPostTempSave(postReq.getPostTempSave());
            post.setPostRegDate(postReq.getPostRegDate());
            post.setPostUpdateDate(postReq.getPostUpdateDate());
            post.setPostTag(postReq.getPostTag());
            post.setPostHits(postReq.getPostHits());
            post.setPostLove(postReq.getPostLove());
            post.setPostUserIndex(postReq.getPostUserIndex());
            post.setSeriesIndex(postReq.getSeriesIndex());

            return post;
        })
                .map(post -> postRepository.save(post))
                .map(post -> response(post))
                .orElseGet(() -> Header.ERROR("No Data"));
    }

    @Override
    public Header delete(Integer postIndex) {
        Optional<PostEntity> post = postRepository.findById(postIndex);

        return post.map(
            PostRes -> {
                postRepository.delete(PostRes);
                return Header.OK();
            }).orElseGet(() -> Header.ERROR(" No data"));
    }   
    
}
