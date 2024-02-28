package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    // You can add custom query methods here if needed
}