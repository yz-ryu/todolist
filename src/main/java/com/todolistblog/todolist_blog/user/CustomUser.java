package com.todolistblog.todolist_blog.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUser implements UserDetails {
    private String username;
    private String password;
    private String name;
    private Collection<? extends GrantedAuthority> authorities;
    private User user;

    public CustomUser(String username, String password, String name, Collection<? extends GrantedAuthority> authorities, User user) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.authorities = authorities;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() { return user; }
}