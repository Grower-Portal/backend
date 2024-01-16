package com.growerportal.GrowerPortal.controller;

import com.growerportal.GrowerPortal.entity.Survey;
import com.growerportal.GrowerPortal.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/survey")
    public class SurveyController {
        private final SurveyService surveyService;

        @Autowired
        public SurveyController(SurveyService surveyService) {
            this.surveyService = surveyService;
        }

        @PostMapping
        public Survey createSurvey(@RequestBody Survey survey) {
            return surveyService.saveSurvey(survey);
        }
    }

