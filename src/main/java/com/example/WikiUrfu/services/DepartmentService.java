package com.example.WikiUrfu.services;

import java.util.UUID;

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

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo, TeacherRepo teacherRepo) {
        this.departmentRepo = departmentRepo;
        this.teacherRepo = teacherRepo;
    }
    
    public DepartmentEntity createDepartment(String name, String description) throws Exception {
        try {
            DepartmentEntity department = new DepartmentEntity(name, description);
            return departmentRepo.save(department);
        } catch (Exception e) {
            throw new Exception(e.getMessage()); //Под рефактор
        }
    }

    public Iterable<DepartmentEntity> getAllDepartments() throws Exception {
        try {
            var departments = departmentRepo.findAll();
            return departments;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DepartmentEntity addTeacherToDepartment(UUID department_id, TeacherEntity teacher) throws Exception {
        try {
            DepartmentEntity department = departmentRepo.findById(department_id).get();
            
            if(department == null)
                throw new DepartmentNotFoundException("Кафедра не найдена");

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
