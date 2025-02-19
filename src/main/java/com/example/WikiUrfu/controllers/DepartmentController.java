package com.example.WikiUrfu.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WikiUrfu.DTOs.AddToDepartmentRequestDto;
import com.example.WikiUrfu.DTOs.DepartmentRequestDto;
import com.example.WikiUrfu.entity.DepartmentEntity;
import com.example.WikiUrfu.entity.TeacherEntity;
import com.example.WikiUrfu.exceptions.DepartmentNotFoundException;
import com.example.WikiUrfu.services.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentRequestDto request) throws Exception {
        try {
            DepartmentEntity department = departmentService.createDepartment(
                request.getName(), 
                request.getDescription(),
                request.getInstituteId()
            );

            return ResponseEntity.ok(department);
        } catch(DepartmentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        try {
            var departments = departmentService.getAllDepartments();
            return ResponseEntity.ok(departments);
        } catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> addTeacherToDepartment(@PathVariable UUID id, 
    @RequestBody AddToDepartmentRequestDto request) throws Exception {
        try {
            TeacherEntity teacher = new TeacherEntity(
                request.getName(),
                request.getBio(),
                request.getAcademicDegree(),
                request.getAcademicRank(),
                request.getDepartment()
            );
    
            departmentService.addTeacherToDepartment(id, teacher);
            return ResponseEntity.ok().body("Преподаватель успешно добавлен на кафедру");
        } catch (DepartmentNotFoundException e) {
            throw new Exception(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable UUID id) throws Exception {
        try {
            departmentService.deleteDepartment(id);
            return ResponseEntity.ok().body("Кафедра успешно удалена из базы");
        } catch(DepartmentNotFoundException e) {
            throw new DepartmentNotFoundException(e.getMessage());
        }
    }
}
