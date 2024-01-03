package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerFieldMapping;
import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerFieldMappingRepository extends JpaRepository<FarmerFieldMapping, Long> {
}
