package com.digi.config;

import com.digi.model.User;
import com.digi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
@Configuration
public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDB = userService.getByEmail(username);
        if (userDB == null){
            throw new RuntimeException();
        }
        Collection<GrantedAuthority> collection = new ArrayList<>();

        return new org.springframework.security.core.userdetails.User(userDB.getEmail(), userDB.getPassword(), collection);
    }
}
