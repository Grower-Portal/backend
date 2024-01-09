package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerRequestForApproval;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRequestForApprovalRepository extends JpaRepository<FarmerRequestForApproval, Long> {

    @Query("SELECT f.framId, SUM(f.rptQty) FROM FarmerRequestForApproval f WHERE f.farmer.farmer_ID = :farmerId GROUP BY f.framId")
    List<Object[]> getAutoPopulatedFields(@Param("farmerId") Long farmerId);
}
