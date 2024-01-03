package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerPersonalInfoRepository extends JpaRepository<FarmerPersonalInfo, Long> {
    Optional<FarmerPersonalInfo> findByEmail(String email);
}