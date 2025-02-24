package com.example.WikiUrfu.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WikiUrfu.entity.*;
import com.example.WikiUrfu.exceptions.*;
import com.example.WikiUrfu.repository.*;


@Service
public class TeacherService {
    
    private final TeacherRepo teacherRepo;
    private final DepartmentRepo departmentRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo, DepartmentRepo departmentRepo) {
        this.teacherRepo = teacherRepo;
        this.departmentRepo = departmentRepo;
    }

    public Iterable<TeacherEntity> getAllTeachers() throws Exception {
        try {
            var teachers = teacherRepo.findAll();
            return teachers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public TeacherEntity getTeacherById(UUID teacher_id) throws Exception {
        try {
            var teacher = teacherRepo.findById(teacher_id)
                .orElseThrow(() -> new TeacherNotFoundException("Преподавателя не существует"));
    
            return teacher;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public TeacherEntity createTeacher(String name, String bio, AcademicDegree academicDegree, 
    AcademicRank academicRank, UUID departmentId) throws DepartmentNotFoundException {
        DepartmentEntity department = departmentRepo.findById(departmentId)
            .orElseThrow(() -> new DepartmentNotFoundException("Кафедра не найдена"));

        TeacherEntity teacher = new TeacherEntity(name, bio, academicDegree, academicRank, department);

        return teacherRepo.save(teacher);
    }

    public UUID deleteTeacher(UUID teacher_id) throws Exception {
        try {
            teacherRepo.findById(teacher_id)
                .orElseThrow(() -> new TeacherNotFoundException("Преподаватель не найден"));
    
            teacherRepo.deleteById(teacher_id);
            return teacher_id;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
