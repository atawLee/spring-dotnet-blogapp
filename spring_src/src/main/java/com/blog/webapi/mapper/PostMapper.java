package com.blog.webapi.mapper;

import com.blog.webapi.dbEntity.Post;
import org.apache.ibatis.annotations.Param;
import java.util.Optional;

public interface PostMapper {
    void insertPost(Post post);
    Optional<Post> getPostById(@Param("id") Long id);
}
