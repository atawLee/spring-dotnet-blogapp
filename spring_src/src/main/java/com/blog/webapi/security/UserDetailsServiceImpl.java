package com.blog.webapi.security;

import com.blog.webapi.mapper.UserMapper;
import com.blog.webapi.repository.UserRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
@Scope
public class UserDetailsServiceImpl implements UserDetailsService, AuthService {
    private final UserRepository userRepository;
    private Hashtable<String,UserDetails> userTable = new Hashtable<String,UserDetails>();

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userTable.containsKey(username)) {
            return userTable.get(username);
        }
        var user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        //todo : implement user details
        UserDetails userDetails = new CustomUserDetails();
        return userDetails;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout(String username) {
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        return false;
    }
}