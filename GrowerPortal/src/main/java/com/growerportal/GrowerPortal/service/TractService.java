package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.Tract;


import java.util.List;

public interface TractService {
    List<Tract> getAllTracts();
    Tract getTractById(Long id);
    Tract createTract(Tract tract);
    Tract updateTract(Long id, Tract tract);
    void deleteTract(Long id);
}


