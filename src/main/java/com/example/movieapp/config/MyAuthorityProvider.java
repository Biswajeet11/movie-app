package com.example.movieapp.config;

import com.example.movieapp.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class MyAuthorityProvider implements AuthenticationProvider {


    @Autowired
    MyUserService myUserService;


    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String userPassword = authentication.getCredentials().toString();

        UserDetails myDbUser = myUserService.loadUserByUsername(userName);
        if(myDbUser != null && passwordEncoder.matches(userPassword,myDbUser.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    authentication.getName(),authentication.getCredentials(),
                    myDbUser.getAuthorities());
        }
        throw new BadCredentialsException("Invalid Credentials");
    }

    public boolean supports(Class<?> authentication){
        if(UsernamePasswordAuthenticationToken.class.equals(authentication)){
            return true;
        } else {
            return false;
        }

     }

}
