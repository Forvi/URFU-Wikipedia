package com.example.WikiUrfu.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WikiUrfu.entity.AcademicDegree;
import com.example.WikiUrfu.entity.AcademicRank;
import com.example.WikiUrfu.entity.DepartmentEntity;
import com.example.WikiUrfu.entity.TeacherEntity;
import com.example.WikiUrfu.exceptions.DepartmentNotFoundException;
import com.example.WikiUrfu.exceptions.TeacherNotFoundException;
import com.example.WikiUrfu.repository.DepartmentRepo;
import com.example.WikiUrfu.repository.TeacherRepo;


@Service
public class TeacherService {

    private final TeacherRepo teacherRepo;
    private final DepartmentRepo departmentRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo, DepartmentRepo departmentRepo) {
        this.teacherRepo = teacherRepo;
        this.departmentRepo = departmentRepo;
    }

    public Iterable<TeacherEntity> getAllTeachers() {
        var teachers = teacherRepo.findAll();
        return teachers;
    }

    public TeacherEntity createTeacher(String name, String bio, AcademicDegree academicDegree,
                                       AcademicRank academicRank, UUID department_id) throws DepartmentNotFoundException {
        DepartmentEntity department = departmentRepo.findById(department_id)
                .orElseThrow(() -> new DepartmentNotFoundException("Кафедра не найдена"));

        TeacherEntity teacher = new TeacherEntity(name, bio, academicDegree, academicRank, department);

        return teacherRepo.save(teacher);
    }

    public UUID deleteTeacher(UUID teacher_id) throws Exception {
        teacherRepo.findById(teacher_id)
                .orElseThrow(() -> new TeacherNotFoundException("Преподаватель не найден"));

        teacherRepo.deleteById(teacher_id);
        return teacher_id;
    }

    public TeacherEntity getTeacherById(UUID teacher_id) throws Exception {
        try {
            var teacher = teacherRepo.findById(teacher_id).orElseThrow(() -> new TeacherNotFoundException("Преподаватель не найден"));
                    return teacher;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

