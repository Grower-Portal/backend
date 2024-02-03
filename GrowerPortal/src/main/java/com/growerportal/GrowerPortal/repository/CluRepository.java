package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.Clu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CluRepository extends JpaRepository<Clu, Long> {
    // Additional query methods can be defined here
}
