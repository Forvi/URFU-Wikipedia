package com.example.WikiUrfu.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WikiUrfu.DTOs.TeacherRequestDto;
import com.example.WikiUrfu.entity.TeacherEntity;
import com.example.WikiUrfu.exceptions.DepartmentNotFoundException;
import com.example.WikiUrfu.exceptions.TeacherNotFoundException;
import com.example.WikiUrfu.services.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teachersService;

    @Autowired
    public TeacherController(TeacherService teachersService) {
        this.teachersService = teachersService;
    }
    
    @PostMapping
    public ResponseEntity<?> createTeacher(@RequestBody TeacherRequestDto request) throws Exception {
        try {

            TeacherEntity teacher = teachersService.createTeacher(
                request.getName(), 
                request.getBio(), 
                request.getAcademicDegree(), 
                request.getAcademicRank(), 
                request.getDepartmentId()
            );

            return ResponseEntity.ok(teacher);
        } catch(DepartmentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable UUID id) throws Exception {
        try {
            teachersService.deleteTeacher(id);
            return ResponseEntity.ok().body("Преподаватель успешно удален из базы");
        } catch(TeacherNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTeachers() {
        var teachers = teachersService.getAllTeachers();
        return ResponseEntity.ok().body(teachers);
    }

}