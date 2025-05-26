package com.example.WikiUrfu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
    
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Setter
    @Column(length = 255, nullable = false)
    private String name;

    @Getter
    @Setter
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "department", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TeacherEntity> teachers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    @JsonBackReference
    private InstituteEntity institute;

    public DepartmentEntity() {
    }    

    public DepartmentEntity(String name, String description, InstituteEntity institute) {
        this.name = name;
        this.description = description;
        this.institute = institute;
    }

    public void addTeacher(TeacherEntity teacher) {
        this.teachers.add(teacher);
    }

    public void setTeachersList(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }

    public List<TeacherEntity> getTeacher() {
        return teachers;
    }
} 
