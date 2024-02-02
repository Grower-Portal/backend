package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FieldHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldHistoryRepository extends JpaRepository<FieldHistory, Long> {
    // Additional query methods can be defined here if needed
}
