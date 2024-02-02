package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    // Additional query methods can be defined here
    Optional<Farm> findByFarmNumber(Long farmNumber);
}