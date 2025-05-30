package com.example.WikiUrfu.controllers;

import com.example.WikiUrfu.exceptions.DepartmentNotFoundException;
import com.example.WikiUrfu.exceptions.TeacherNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

import com.example.WikiUrfu.DTOs.TeacherRequestDto;
import com.example.WikiUrfu.entity.TeacherEntity;
import com.example.WikiUrfu.services.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
@Tag(name = "Teacher Management", description = "Управление преподавателями")
public class TeacherController {

    private TeacherService teachersService;

    @Operation(summary = "Создать преподавателя")
    @ApiResponse(responseCode = "201", description = "Преподаватель создан")
    @PostMapping
    public ResponseEntity<TeacherEntity> createTeacher(
            @RequestBody @Valid TeacherRequestDto request) throws DepartmentNotFoundException {

        TeacherEntity teacher = teachersService.createTeacher(
                request.getName(),
                request.getBio(),
                request.getAcademicDegree(),
                request.getAcademicRank(),
                request.getDepartmentId()
        );

        return ResponseEntity.status(201).body(teacher);
    }

    @Operation(summary = "Получить всех преподавателей")
    @GetMapping
    public ResponseEntity<List<TeacherEntity>> getAllTeachers() {
        return ResponseEntity.ok(teachersService.getAllTeachers());
    }

    @Operation(summary = "Получить преподавателя по ID")
    @GetMapping("/{id}")
    public ResponseEntity<TeacherEntity> getTeacherById(
            @PathVariable UUID id) throws TeacherNotFoundException {

        return ResponseEntity.ok(teachersService.getTeacherById(id));
    }

    @Operation(summary = "Удалить преподавателя")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable UUID id) throws TeacherNotFoundException {
        teachersService.deleteTeacher(id);
        return ResponseEntity.ok("Преподаватель успешно удален");
    }
}