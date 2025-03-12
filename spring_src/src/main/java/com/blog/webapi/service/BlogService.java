package com.blog.webapi.service;

import com.blog.webapi.apiDto.PostSummaryDto;
import com.blog.webapi.apiDto.PostDetailResponseDto;
import com.blog.webapi.apiDto.PostSummaryListResponseDto;
import com.blog.webapi.apiDto.UpdatePostRequestDto;
import com.blog.webapi.dbEntity.Post;
import com.blog.webapi.repository.BlogRepository;

import java.util.ArrayList;

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

    public PostDetailResponseDto getPostById(Long id) {
        Post item = blogRepository.getPostById(id);
        if(item == null )throw new RuntimeException("Post not found");
        return new PostDetailResponseDto(
                item.getId(),
                item.getUserId(),
                item.getTitle(),
                item.getContent());
    }

    public PostSummaryListResponseDto getPosts(long userId,int page, int rawCount){
        var postList = blogRepository.getPosts(userId, page, rawCount);
        ArrayList<PostSummaryDto> dtoList = new ArrayList<>();
        for (Post item : postList) {
            dtoList.add(new PostSummaryDto(
                    item.getId(),
                    item.getUserId(),
                    item.getTitle()));
        }
        return new PostSummaryListResponseDto(dtoList);
    }

    public void deletePost(long userId,long id){
        blogRepository.deletePost(id, userId);
    }

    public void updatePost(long userId, UpdatePostRequestDto updateData){
        Post post = new Post();
        post.setId(updateData.getId());
        post.setContent(updateData.getContent());
        post.setTitle(updateData.getTitle());
        post.setUserId(userId);
        blogRepository.updatePost(post);
    }
}