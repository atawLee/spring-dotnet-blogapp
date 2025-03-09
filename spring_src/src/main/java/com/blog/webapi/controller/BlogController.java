package com.blog.webapi.controller;

import com.blog.webapi.service.BlogService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
}
