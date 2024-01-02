package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerRequestForApproval;
import com.growerportal.GrowerPortal.entity.FieldCsvLocationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldCsvLocationDetailsRepository extends JpaRepository<FieldCsvLocationDetails, Long> {

}
