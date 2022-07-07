package com.example.nowSecurity;

import com.example.nowSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
