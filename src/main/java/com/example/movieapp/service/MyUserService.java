package com.example.movieapp.service;

import com.example.movieapp.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class MyUserService implements UserDetailsService {

    Map<String,UserDetails> userDetailsMap = new HashMap<>();

    public UserDetails loadUserByUsername(String userName) {
        return userDetailsMap.getOrDefault(userName, new User());
    }

    public void addUser(User user){
     this.userDetailsMap.put(user.getUsername(),user);
    }
}
