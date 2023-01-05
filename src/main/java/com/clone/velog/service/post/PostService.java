package com.clone.velog.service.post;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .build();
        return Header.OK(postRes);
    }

    @Override
    public Header<PostRes> read(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header<PostRes> update(Header<PostReq> request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Header delete(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
