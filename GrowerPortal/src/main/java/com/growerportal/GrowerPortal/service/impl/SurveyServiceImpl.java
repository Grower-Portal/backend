package com.growerportal.GrowerPortal.service.impl;
import com.growerportal.GrowerPortal.entity.Survey;
import com.growerportal.GrowerPortal.repository.SurveyRepository;
import com.growerportal.GrowerPortal.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }
}
