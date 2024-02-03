package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.AddApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddApplicationRepository extends JpaRepository<AddApplication, Long> {
    // Additional query methods can be defined here
}
