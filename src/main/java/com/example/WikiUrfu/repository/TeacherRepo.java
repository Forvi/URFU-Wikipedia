package com.example.WikiUrfu.repository;

import com.example.WikiUrfu.entity.TeacherEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface TeacherRepo extends JpaRepository<TeacherEntity, UUID> {

    @EntityGraph(attributePaths = {"department", "department.institute"})
    @Query("SELECT t FROM TeacherEntity t WHERE t.id = :id")
    Optional<TeacherEntity> findByIdWithRelations(@Param("id") UUID id);

    int deleteByCreatedAtBefore(LocalDateTime oneYearAgo);
}
