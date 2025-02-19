package com.example.WikiUrfu.services;


import com.example.WikiUrfu.entity.InstituteEntity;
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

    public InstituteEntity createInstitute (String name, String description) throws Exception {
        try {
            InstituteEntity institute = new InstituteEntity(name, description);
            return institutesRepo.save(institute);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Iterable<InstituteEntity> getAllInstitutes() throws Exception {
        try {
            Iterable<InstituteEntity> institutes = institutesRepo.findAll();
            return institutes;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public InstituteEntity getInstituteById(UUID institiute_id) throws Exception {
        try {
            var institute = institutesRepo.findById(institiute_id)
                .orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));

            return institute;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UUID deleteInstituteById(UUID institute_id) throws Exception {
        institutesRepo.findById(institute_id)
            .orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));

        institutesRepo.deleteById(institute_id);
        return institute_id;
    }
}
