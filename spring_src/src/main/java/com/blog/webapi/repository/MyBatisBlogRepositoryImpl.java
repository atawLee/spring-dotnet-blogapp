package com.blog.webapi.repository;

import com.blog.webapi.dbEntity.Post;
import com.blog.webapi.mapper.PostMapper;
import com.blog.webapi.service.BlogService;


public class MyBatisBlogRepositoryImpl implements BlogRepository {

    PostMapper postMapper;

    public MyBatisBlogRepositoryImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public void savePost(Long userId, String title, String content) {
        Post post = new Post();
        post.setUserId(userId);
        post.setTitle(title);
        post.setContent(content);
        postMapper.insertPost(post);
    }
}
