package com.example.WikiUrfu.controllers;

import com.example.WikiUrfu.entity.TeacherEntity;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;


import com.example.WikiUrfu.DTOs.AddToDepartmentRequestDto;
import com.example.WikiUrfu.DTOs.DepartmentRequestDto;
import com.example.WikiUrfu.entity.DepartmentEntity;
import com.example.WikiUrfu.exceptions.DepartmentNotFoundException;
import com.example.WikiUrfu.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@Tag(name = "Department Management", description = "Управление кафедрами")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(summary = "Создать кафедру")
    @ApiResponse(responseCode = "200", description = "Кафедра создана")
    @PostMapping
    public ResponseEntity<DepartmentEntity> createDepartment(
            @RequestBody @Valid DepartmentRequestDto request) {

        DepartmentEntity department = departmentService.createDepartment(
                request.getName(),
                request.getDescription(),
                request.getInstituteId()
        );

        return ResponseEntity.ok(department);
    }

    @Operation(summary = "Получить все кафедры")
    @GetMapping
    public ResponseEntity<List<DepartmentEntity>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @Operation(summary = "Получить кафедру по ID")
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentEntity> getDepartmentById(
            @PathVariable UUID id) throws DepartmentNotFoundException {

        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @Operation(summary = "Добавить преподавателя на кафедру")
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentEntity> addTeacherToDepartment(
            @PathVariable UUID id,
            @RequestBody AddToDepartmentRequestDto request) throws DepartmentNotFoundException {

        TeacherEntity teacher = new TeacherEntity(
                request.getName(),
                request.getBio(),
                request.getAcademicDegree(),
                request.getAcademicRank(),
                null
        );

        return ResponseEntity.ok(departmentService.addTeacherToDepartment(id, teacher));
    }

    @Operation(summary = "Удалить кафедру")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable UUID id) throws DepartmentNotFoundException {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Кафедра успешно удалена");
    }
}
