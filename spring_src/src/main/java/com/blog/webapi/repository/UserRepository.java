package com.blog.webapi.repository;

import com.blog.webapi.dbentity.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void update(User user);
    void deleteById(Long id);
}