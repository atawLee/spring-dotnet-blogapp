package com.blog.webapi.apidto;

public class PostDetailResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;

    public PostDetailResponseDto(Long id, Long userId, String title, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
