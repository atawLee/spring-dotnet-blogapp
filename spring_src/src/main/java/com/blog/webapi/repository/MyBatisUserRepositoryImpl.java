package com.blog.webapi.repository;

import com.blog.webapi.dbentity.User;
import com.blog.webapi.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MyBatisUserRepositoryImpl implements UserRepository {

    private final UserMapper userMapper;

    public MyBatisUserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void save(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMapper.getUserById(id));
    }

    @Override
    public List<User> findAll() {
        return userMapper.getAllUsers();
    }

    @Override
    public void update(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteUser(id);
    }
}