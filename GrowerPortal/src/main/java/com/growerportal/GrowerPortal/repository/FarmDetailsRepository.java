package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmDetailsRepository extends JpaRepository<FarmDetails, Long> {
    // Custom query methods can be defined here if needed
}
