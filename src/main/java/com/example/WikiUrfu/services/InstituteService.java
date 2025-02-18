package com.example.WikiUrfu.services;


import com.example.WikiUrfu.entity.InstitutesEntity;
import com.example.WikiUrfu.exceptions.InstituteAlreadyExistsException;
import com.example.WikiUrfu.exceptions.InstituteNotFoundException;
import com.example.WikiUrfu.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InstituteService {
    private final InstituteRepo institutesRepo;

    @Autowired
    public InstituteService(InstituteRepo instituteRepo) {
        this.institutesRepo = instituteRepo;
    }

    public InstitutesEntity createInstitute (String name, String description) throws Exception {
        try {
            InstitutesEntity institute = new InstitutesEntity(name, description);
            return institutesRepo.save(institute);
        } catch(Exception e) {
            throw new InstituteAlreadyExistsException("Институт уже существует");
        }
    }

    public Iterable<InstitutesEntity> getAllInstitutes() throws Exception {
        try {
            Iterable<InstitutesEntity> institutes = institutesRepo.findAll();
            return institutes;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UUID deleteInstituteById(UUID institute_id) throws Exception {
        institutesRepo.findById(institute_id).orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));
        institutesRepo.deleteById(institute_id);
        return institute_id;
    }
}
