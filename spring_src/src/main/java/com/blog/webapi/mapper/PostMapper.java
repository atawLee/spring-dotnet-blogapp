package com.blog.webapi.mapper;

import com.blog.webapi.dbEntity.Post;
import org.apache.ibatis.annotations.Param;

public interface PostMapper {
    void insertPost(Post post);
    Post getPostById(@Param("id") Long id);
}
