package com.blog.webapi.mapper;

import com.blog.webapi.dbentity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {
    void insertPost(Post post);
    Post getPostById(@Param("id") Long id);
    List<Post> getPosts(@Param("userId") long userId, @Param("page") int page, @Param("rawCount") int rawCount);
    void deletePost(@Param("id") long id, @Param("userId") long userId);
    void updatePost(Post post);

}
