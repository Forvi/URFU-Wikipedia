package com.example.WikiUrfu.repository;

import com.example.WikiUrfu.entity.InstitutesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InstituteRepo extends CrudRepository<InstitutesEntity, UUID> {
}
