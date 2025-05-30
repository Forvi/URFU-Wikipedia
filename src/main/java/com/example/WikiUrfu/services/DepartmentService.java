package com.example.WikiUrfu.services;

import java.util.UUID;
import java.util.List;

import com.example.WikiUrfu.entity.DepartmentEntity;
import com.example.WikiUrfu.entity.InstituteEntity;
import com.example.WikiUrfu.entity.TeacherEntity;
import com.example.WikiUrfu.events.DepartmentEvent;
import com.example.WikiUrfu.exceptions.DepartmentNotFoundException;
import com.example.WikiUrfu.exceptions.InstituteNotFoundException;
import com.example.WikiUrfu.repository.DepartmentRepo;
import com.example.WikiUrfu.repository.InstituteRepo;
import com.example.WikiUrfu.repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final TeacherRepo teacherRepo;
    private final InstituteRepo instituteRepo;
    private final ApplicationEventPublisher eventPublisher;

    @CacheEvict(value = "departments", allEntries = true)
    @Transactional
    public DepartmentEntity createDepartment(String name, String description, UUID institute_id) {
        InstituteEntity institute = instituteRepo.findById(institute_id)
                .orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));

        DepartmentEntity department = new DepartmentEntity(name, description, institute);
        DepartmentEntity saved = departmentRepo.save(department);

        eventPublisher.publishEvent(new DepartmentEvent(this, saved, "Создана"
        ));

        return saved;
    }

    @Cacheable("departments")
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Cacheable(value = "departments", key = "#department_id")
    public DepartmentEntity getDepartmentById(UUID department_id) throws DepartmentNotFoundException {
        return departmentRepo.findById(department_id)
                .orElseThrow(() -> new DepartmentNotFoundException("Кафедра не найдена"));
    }

    @CacheEvict(value = "departments", allEntries = true)
    @Transactional
    public DepartmentEntity addTeacherToDepartment(UUID department_id, TeacherEntity teacher) throws DepartmentNotFoundException {
        DepartmentEntity department = departmentRepo.findById(department_id)
                .orElseThrow(() -> new DepartmentNotFoundException("Кафедра не найдена"));

        teacher.setDepartment(department);
        teacherRepo.save(teacher);

        department.addTeacher(teacher);
        DepartmentEntity updated = departmentRepo.save(department);

        eventPublisher.publishEvent(new DepartmentEvent(
                this, updated, "Преподаватель добавлен"
        ));

        return updated;
    }

    @CacheEvict(value = "departments", allEntries = true)
    @Transactional
    public UUID deleteDepartment(UUID department_id) throws DepartmentNotFoundException {
        DepartmentEntity department = departmentRepo.findById(department_id)
                .orElseThrow(() -> new DepartmentNotFoundException("Кафедра не найдена"));

        departmentRepo.delete(department);

        eventPublisher.publishEvent(new DepartmentEvent(
                this, department, "Удалена"
        ));

        return department_id;
    }
}
