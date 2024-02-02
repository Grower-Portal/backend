package com.growerportal.GrowerPortal.service;

import com.growerportal.GrowerPortal.entity.Clu;
import com.growerportal.GrowerPortal.repository.CluRepository;
import com.growerportal.GrowerPortal.util.CluNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CluService {
    List<Clu> getAllClus();
    Clu getCluById(Long id);
    Clu createClu(Clu clu);
    Clu updateClu(Long id, Clu clu);
    void deleteClu(Long id);
}


