package com.example.WikiUrfu.entity;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String name;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String bio;

    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @Enumerated(EnumType.STRING)
    private AcademicRank academicRank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentEntity department;

    public TeacherEntity(String name, String bio, AcademicDegree academicDegree, 
                        AcademicRank academicRank, DepartmentEntity department_id) {
        this.name = name;
        this.bio = bio;
        this.academicDegree = academicDegree;
        this.academicRank = academicRank;
        this.department = department_id;
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
