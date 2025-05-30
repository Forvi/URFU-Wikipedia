package com.example.WikiUrfu.repository;

import com.example.WikiUrfu.entity.InstituteEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;
import java.util.Optional;

public interface InstituteRepo extends JpaRepository<InstituteEntity, UUID> {
    @EntityGraph(attributePaths = {"departments"})
    @Query("SELECT i FROM InstituteEntity i WHERE i.id = :id")
    Optional<InstituteEntity> findByIdWithDepartments(@Param("id") UUID id);
}
