package com.blog.webapi.repository;

import com.blog.webapi.dbEntity.Post;


import java.util.List;

public interface BlogRepository {
    public void savePost(Post post);
    public Post getPostById(Long id);
    public List<Post> getPosts(long userId, int page, int rawCount);
    void deletePost(long id, long userId);
    void updatePost(Post post);
}
