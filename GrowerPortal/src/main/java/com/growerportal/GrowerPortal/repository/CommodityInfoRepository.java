package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.CommodityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityInfoRepository extends JpaRepository<CommodityInfo, Long> {
    // Additional custom query methods can be defined here if needed
}
