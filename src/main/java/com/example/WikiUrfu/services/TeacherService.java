package com.example.WikiUrfu.services;

import java.util.UUID;
import java.util.List;

import com.example.WikiUrfu.entity.*;
import com.example.WikiUrfu.events.TeacherEvent;
import com.example.WikiUrfu.exceptions.*;
import com.example.WikiUrfu.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepo teacherRepo;
    private final DepartmentRepo departmentRepo;
    private final ApplicationEventPublisher eventPublisher;

    @Cacheable("teachers")
    public List<TeacherEntity> getAllTeachers() {
        return (List<TeacherEntity>) teacherRepo.findAll();
    }

    @CacheEvict(value = "teachers", allEntries = true)
    @Transactional
    public TeacherEntity createTeacher(String name, String bio, AcademicDegree academicDegree,
                                       AcademicRank academicRank, UUID department_id) throws DepartmentNotFoundException {

        DepartmentEntity department = departmentRepo.findById(department_id)
                .orElseThrow(() -> new DepartmentNotFoundException("Кафедра не найдена"));

        TeacherEntity teacher = new TeacherEntity(name, bio, academicDegree, academicRank, department);
        TeacherEntity saved = teacherRepo.save(teacher);

        eventPublisher.publishEvent(new TeacherEvent(
                this,
                saved,
                "Создан"
        ));

        return saved;
    }

    @CacheEvict(value = "teachers", key = "#teacher_id")
    @Transactional
    public UUID deleteTeacher(UUID teacher_id) throws TeacherNotFoundException {
        TeacherEntity teacher = teacherRepo.findById(teacher_id)
                .orElseThrow(() -> new TeacherNotFoundException("Преподаватель не найден"));

        teacherRepo.delete(teacher);

        eventPublisher.publishEvent(new TeacherEvent(
                this,
                teacher,
                "Удален"
        ));

        return teacher_id;
    }

    @Cacheable(value = "teachers", key = "#teacher_id")
    public TeacherEntity getTeacherById(UUID teacher_id) throws TeacherNotFoundException {
        return teacherRepo.findById(teacher_id)
                .orElseThrow(() -> new TeacherNotFoundException("Преподаватель не найден"));
    }
}

