package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.FarmerPersonalInfo;
import com.growerportal.GrowerPortal.entity.FieldCsvDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldCsvDetailsRepository extends JpaRepository<FieldCsvDetails, Long> {

    @Query("SELECT ld.fsaPhysicalLocation FROM FieldCsvDetails ld WHERE ld.farmNumber = :farmNumber AND ld.tractNumber = :tractNumber AND ld.cluNumber = :cluNumber")
    String findFsaPhysicalLocationByFarmTractClu(
            @Param("farmNumber") Long farmNumber,
            @Param("tractNumber") Long tractNumber,
            @Param("cluNumber") Long cluNumber);

    @Query("SELECT ld.cluCalculatedAcreage FROM FieldCsvDetails ld WHERE ld.farmNumber = :farmNumber AND ld.tractNumber = :tractNumber AND ld.cluNumber = :cluNumber")
    Double findCluCalculatedAcreageByFarmTractClu(
            @Param("farmNumber") Long farmNumber,
            @Param("tractNumber") Long tractNumber,
            @Param("cluNumber") Long cluNumber);

}
