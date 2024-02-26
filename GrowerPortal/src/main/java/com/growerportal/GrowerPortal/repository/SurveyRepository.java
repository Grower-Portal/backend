package com.growerportal.GrowerPortal.repository;

import com.growerportal.GrowerPortal.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    List<Survey> findByProducerInfo_ProducerInfoId(Long producerInfoId);
}
