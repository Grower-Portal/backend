package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    // can define custom query methods here if needed
}

