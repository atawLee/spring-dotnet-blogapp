package com.blog.webapi.repository;

import java.time.LocalDateTime;

public interface BlogRepository {
    public void savePost(Long userId, String title, String content);
}
