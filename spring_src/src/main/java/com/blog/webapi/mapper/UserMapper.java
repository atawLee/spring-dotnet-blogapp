package com.blog.webapi.mapper;

import com.blog.webapi.dbentity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    void insertUser(User user);

    User getUserById(@Param("id") Long id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(@Param("id") Long id);
}
