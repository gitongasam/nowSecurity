package com.example.nowSecurity.Config;


import com.example.nowSecurity.Entity.User;
import com.example.nowSecurity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email);
        if (user==null){
            throw new UsernameNotFoundException("user not found");

        }
        return new CustomUserDetails(user);
    }
}

