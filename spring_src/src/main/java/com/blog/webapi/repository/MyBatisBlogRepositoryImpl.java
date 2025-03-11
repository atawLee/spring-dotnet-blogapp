package com.blog.webapi.repository;

import com.blog.webapi.dbEntity.Post;
import com.blog.webapi.mapper.PostMapper;

public class MyBatisBlogRepositoryImpl implements BlogRepository {
    PostMapper postMapper;
    public MyBatisBlogRepositoryImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public void savePost(Post post) {
        postMapper.insertPost(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postMapper.getPostById(id);
    }
}
