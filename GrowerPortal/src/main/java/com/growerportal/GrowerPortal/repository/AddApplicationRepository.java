package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.AddApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddApplicationRepository extends JpaRepository<AddApplication, Long> {
    @Query("SELECT a FROM AddApplication a WHERE a.farmer.farmer_ID = :farmerId")
    List<AddApplication> findByFarmerId(@Param("farmerId") Long farmerId);
}