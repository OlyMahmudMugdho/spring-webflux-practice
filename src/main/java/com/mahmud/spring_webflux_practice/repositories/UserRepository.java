package com.mahmud.spring_webflux_practice.repositories;

import com.mahmud.spring_webflux_practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
