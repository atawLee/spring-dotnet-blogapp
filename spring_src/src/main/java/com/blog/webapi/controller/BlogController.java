package com.blog.webapi.controller;

import com.blog.webapi.apidto.AddPostRequestDto;
import com.blog.webapi.apidto.PostDetailResponseDto;
import com.blog.webapi.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/post")
    @PreAuthorize("isAuthenticated()")
    public void addPost(AddPostRequestDto dto){
        blogService.savePost(dto.getUserId(), dto.getTitle(), dto.getContent());
    }

    @GetMapping("/post")
    public ResponseEntity<PostDetailResponseDto> getPost(long id) {
         var item = blogService.getPostById(id);
         return ResponseEntity.ok(item);
    }
}


