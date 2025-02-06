package com.example.WikiUrfu.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String bio;
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;
    @Enumerated(EnumType.STRING)
    private AcademicRank academicRank;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    private DepartmentEntity department;

    public TeacherEntity(String name, String bio, AcademicDegree academicDegree, 
                        AcademicRank academicRank, DepartmentEntity department) {
        this.name = name;
        this.bio = bio;
        this.academicDegree = academicDegree;
        this.academicRank = academicRank;
        this.department = department;
    }

    public TeacherEntity() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }
    
    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicRank(AcademicRank rank) {
        this.academicRank = rank;
    }

    public AcademicRank getAcademicRank() {
        return academicRank;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public UUID getId() {
        return id;
    }
}
