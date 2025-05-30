package com.example.WikiUrfu.services;


import com.example.WikiUrfu.entity.InstituteEntity;
import com.example.WikiUrfu.events.InstituteEvent;
import com.example.WikiUrfu.exceptions.InstituteNotFoundException;
import com.example.WikiUrfu.repository.InstituteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class InstituteService {
    private final InstituteRepo institutesRepo;
    private final ApplicationEventPublisher eventPublisher;


    @CacheEvict(value = "institutes", allEntries = true)
    @Transactional
    public InstituteEntity createInstitute(String name, String description) {
        InstituteEntity institute = new InstituteEntity(name, description);
        InstituteEntity saved = instituteRepo.save(institute);

        eventPublisher.publishEvent(new InstituteEvent(
                this, saved, "Создан"
        ));

        return saved;
    }

    @Cacheable("institutes")
    public List<InstituteEntity> getAllInstitutes() {
        return instituteRepo.findAll();
    }

    @Cacheable(value = "institutes", key = "#institute_id")
    public InstituteEntity getInstituteById(UUID institute_id) {
        return instituteRepo.findById(institute_id)
                .orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));
    }

    @CacheEvict(value = "institutes", allEntries = true)
    @Transactional
    public UUID deleteInstituteById(UUID institute_id) {
        InstituteEntity institute = instituteRepo.findById(institute_id)
                .orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));

        instituteRepo.delete(institute);

        eventPublisher.publishEvent(new InstituteEvent(
                this, institute, "Удален"
        ));

        return institute_id;
    }
}
