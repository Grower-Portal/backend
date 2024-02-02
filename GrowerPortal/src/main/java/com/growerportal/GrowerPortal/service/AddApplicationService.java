package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.AddApplication;
import com.growerportal.GrowerPortal.repository.AddApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddApplicationService {

    @Autowired
    private AddApplicationRepository addApplicationRepository;

    public List<AddApplication> getAllApplications() {
        return addApplicationRepository.findAll();
    }

    public Optional<AddApplication> getApplicationById(Long id) {
        return addApplicationRepository.findById(id);
    }

    public AddApplication createApplication(AddApplication application) {
        return addApplicationRepository.save(application);
    }

    public void updateApplication(Long id, AddApplication updatedApplication) {
        if (addApplicationRepository.existsById(id)) {
            updatedApplication.setApplicationId(id);
            addApplicationRepository.save(updatedApplication);
        }
    }

    public void deleteApplication(Long id) {
        addApplicationRepository.deleteById(id);
    }
}

