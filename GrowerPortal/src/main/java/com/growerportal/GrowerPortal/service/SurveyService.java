package com.growerportal.GrowerPortal.service;
import com.growerportal.GrowerPortal.dto.AddApplicationDto;
import com.growerportal.GrowerPortal.dto.SurveyDto;
import com.growerportal.GrowerPortal.entity.ProducerInfo;
import com.growerportal.GrowerPortal.entity.Survey;

import java.io.IOException;

public interface SurveyService {

    Survey saveSurvey(SurveyDto survey) throws IOException;
}