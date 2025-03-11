package com.blog.webapi.service;

import com.blog.webapi.apiDto.PostResponseDto;
import com.blog.webapi.dbEntity.Post;
import com.blog.webapi.repository.BlogRepository;

import java.util.Optional;

public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void savePost(Long userId, String title, String content) {
        Post post = new Post();
        post.setUserId(userId);
        post.setTitle(title);
        post.setContent(content);
        blogRepository.savePost(post);
    }

    public PostResponseDto getPostById(Long id) {
        Post item = blogRepository.getPostById(id);
        if(item == null )throw new RuntimeException("Post not found");
        return new PostResponseDto(
                item.getId(),
                item.getUserId(),
                item.getTitle(),
                item.getContent());
    }
}

