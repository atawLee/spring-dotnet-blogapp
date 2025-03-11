package com.blog.webapi.apiDto;

public class PostResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;

    public PostResponseDto(Long id, Long userId, String title, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
