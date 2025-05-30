package com.example.WikiUrfu.repository;

import com.example.WikiUrfu.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, UUID> {

    @EntityGraph(attributePaths = {"teachers", "institute"})
    @Query("SELECT d FROM DepartmentEntity d WHERE d.id = :id")
    Optional<DepartmentEntity> findByIdWithRelations(@Param("id") UUID id);
}