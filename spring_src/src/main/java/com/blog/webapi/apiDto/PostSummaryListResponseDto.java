package com.blog.webapi.apiDto;

import java.util.ArrayList;

public class PostSummaryListResponseDto {
    private final ArrayList<PostSummaryDto> posts;

    public PostSummaryListResponseDto(ArrayList<PostSummaryDto> posts) {
        this.posts = posts;
    }
}
