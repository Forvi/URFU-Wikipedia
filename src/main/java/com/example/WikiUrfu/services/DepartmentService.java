package com.example.WikiUrfu.services;

import java.util.UUID;

import com.example.WikiUrfu.entity.InstituteEntity;
import com.example.WikiUrfu.exceptions.InstituteNotFoundException;
import com.example.WikiUrfu.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WikiUrfu.entity.DepartmentEntity;
import com.example.WikiUrfu.entity.TeacherEntity;
import com.example.WikiUrfu.exceptions.DepartmentNotFoundException;
import com.example.WikiUrfu.repository.DepartmentRepo;
import com.example.WikiUrfu.repository.TeacherRepo;

@Service
public class DepartmentService {
    
    private final DepartmentRepo departmentRepo;
    private final TeacherRepo teacherRepo;
    private final InstituteRepo instituteRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo, TeacherRepo teacherRepo, InstituteRepo instituteRepo) {
        this.departmentRepo = departmentRepo;
        this.teacherRepo = teacherRepo;
        this.instituteRepo = instituteRepo;
    }
    
    public DepartmentEntity createDepartment(String name, String description, UUID institute_id) throws Exception {
        try {
            InstituteEntity institute = instituteRepo.findById(institute_id)
                    .orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));

            DepartmentEntity department = new DepartmentEntity(name, description, institute);

            return departmentRepo.save(department);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Iterable<DepartmentEntity> getAllDepartments() throws Exception {
        try {
            return departmentRepo.findAll();
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DepartmentEntity getDepartmentById(UUID department_id) throws Exception {
        try {
            var department = departmentRepo.findById(department_id)
                .orElseThrow(() -> new DepartmentNotFoundException("Кафедры не существует"));
            return department;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DepartmentEntity addTeacherToDepartment(UUID department_id, TeacherEntity teacher) throws Exception {
        try {
            DepartmentEntity department = departmentRepo.findById(department_id)
                    .orElseThrow(() -> new InstituteNotFoundException("Институт не найден"));;

            teacher.setDepartment(department);
            teacherRepo.save(teacher);
    
            department.addTeacher(teacher);
            return departmentRepo.save(department);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UUID deleteDepartment(UUID department_id) throws Exception {
        departmentRepo.findById(department_id)
            .orElseThrow(() -> new DepartmentNotFoundException("Кафедра не найдена"));

        departmentRepo.deleteById(department_id);
        return department_id;
    }
}
