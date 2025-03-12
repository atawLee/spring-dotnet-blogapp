package com.blog.webapi.apidto;

public class PostSummaryDto {
    private Long id;
    private Long userId;
    private String title;

    public PostSummaryDto(Long id, Long userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }
}
