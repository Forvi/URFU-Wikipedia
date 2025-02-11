package com.example.WikiUrfu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TeacherEntity> teacher = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "institute_id")
    private InstitutesEntity institute;

    public DepartmentEntity() {
    }    

    public DepartmentEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void addTeacher(TeacherEntity teacher) {
        this.teacher.add(teacher);
    }

    public void setTeachersList(List<TeacherEntity> teachers) {
        this.teacher = teachers;
    }

    public List<TeacherEntity> getTeacher() {
        return teacher;
    }
} 
