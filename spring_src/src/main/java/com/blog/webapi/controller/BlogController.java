package com.blog.webapi.controller;

import com.blog.webapi.service.BlogService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final BlogService blogService;

    public PostController(BlogService blogService) {
        this.blogService = blogService;
    }
}
