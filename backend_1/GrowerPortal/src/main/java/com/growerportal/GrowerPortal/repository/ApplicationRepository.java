package com.growerportal.GrowerPortal.repository;

// ApplicationRepository.java

import com.growerportal.GrowerPortal.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Add custom queries or methods if needed
}
