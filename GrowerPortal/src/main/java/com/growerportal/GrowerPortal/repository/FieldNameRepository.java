package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FieldName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldNameRepository extends JpaRepository<FieldName, Long> {
    // Additional query methods can be defined here
}
