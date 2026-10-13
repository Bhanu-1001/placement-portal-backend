package com.placement.portal.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.portal.model.User;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}