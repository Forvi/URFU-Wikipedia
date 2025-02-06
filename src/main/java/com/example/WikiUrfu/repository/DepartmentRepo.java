package com.example.WikiUrfu.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.WikiUrfu.entity.DepartmentEntity;

public interface DepartmentRepo extends CrudRepository<DepartmentEntity, UUID> {
}
