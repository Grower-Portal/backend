package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.dto.SurveyDto;
import com.growerportal.GrowerPortal.entity.Survey;
import com.growerportal.GrowerPortal.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {
    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @CrossOrigin(
            origins = "http://localhost:3000",
            methods = {RequestMethod.POST},
            allowedHeaders = {"Authorization", "Content-Type"})
    @PostMapping(consumes = {"multipart/form-data"})
    public Survey createSurvey(@ModelAttribute SurveyDto survey) throws IOException {
        return surveyService.saveSurvey(survey);
    }
}
