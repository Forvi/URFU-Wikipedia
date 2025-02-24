package com.example.WikiUrfu.controllers;

import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.WikiUrfu.DTOs.TeacherRequestDto;
import com.example.WikiUrfu.entity.TeacherEntity;
import com.example.WikiUrfu.exceptions.*;
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
    public ResponseEntity<?> createTeacher(@RequestBody @Valid TeacherRequestDto request) throws Exception {
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
            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable UUID id) throws Exception {
        try {
            teachersService.deleteTeacher(id);
            return ResponseEntity.ok().body("Преподаватель успешно удален из базы");
        } catch(TeacherNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTeachers() throws Exception {
        var teachers = teachersService.getAllTeachers();
        return ResponseEntity.ok().body(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable UUID id) throws Exception {
        try {
            var teacher = teachersService.getTeacherById(id);
            return ResponseEntity.ok(teacher);
        } catch (TeacherNotFoundException e) {
            throw new TeacherNotFoundException(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}