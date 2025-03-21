package com.blog.webapi.security;


public interface AuthService {

    public boolean login(String username, String password);
    public boolean logout(String username);
    public boolean register(String username, String password);
}
