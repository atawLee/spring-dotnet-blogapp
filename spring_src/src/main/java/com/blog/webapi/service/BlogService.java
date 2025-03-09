package com.blog.webapi.service;

import com.blog.webapi.repository.BlogRepository;

public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void savePost(Long userId, String title, String content) {
        blogRepository.savePost(userId, title, content);
    }

}
