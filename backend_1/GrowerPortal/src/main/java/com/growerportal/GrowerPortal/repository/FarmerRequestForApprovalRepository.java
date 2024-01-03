package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerRequestForApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRequestForApprovalRepository extends JpaRepository<FarmerRequestForApproval, Long> {

}
