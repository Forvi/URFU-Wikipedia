package com.example.WikiUrfu.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.WikiUrfu.entity.TeacherEntity;

public interface TeacherRepo extends CrudRepository<TeacherEntity, UUID> {
}
