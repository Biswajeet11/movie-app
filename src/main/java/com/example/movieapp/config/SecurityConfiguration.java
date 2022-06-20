package com.example.movieapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {

    public PasswordEncoder getMyPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
