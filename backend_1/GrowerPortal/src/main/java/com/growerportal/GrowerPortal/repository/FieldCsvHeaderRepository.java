package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.FieldCsvHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldCsvHeaderRepository extends JpaRepository<FieldCsvHeader, Long> {

}
