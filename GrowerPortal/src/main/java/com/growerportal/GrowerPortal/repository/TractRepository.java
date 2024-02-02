package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.Tract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TractRepository extends JpaRepository<Tract, Long> {
    // Additional query methods can be defined here
}

