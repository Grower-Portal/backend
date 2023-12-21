package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}