package com.blog.webapi.repository;

import com.blog.webapi.dbentity.Post;
import com.blog.webapi.mapper.PostMapper;

import java.util.List;

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

    @Override
    public List<Post> getPosts(long userId, int page, int rawCount) {
        return postMapper.getPosts(userId,page,rawCount);
    }

    @Override
    public void deletePost(long id, long userId) {
        postMapper.deletePost(id, userId);
    }

    @Override
    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }
}
