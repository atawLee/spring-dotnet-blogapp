package com.blog.webapi.repository;

import com.blog.webapi.dbEntity.Post;

public interface BlogRepository {
    public void savePost(Post post);
    public Post getPostById(Long id);
}
