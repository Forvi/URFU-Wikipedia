package com.example.WikiUrfu.entity;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teachers")
public class TeacherEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Setter
    @Column(length = 80, nullable = false)
    private String name;

    @Getter
    @Setter
    @Lob
    @Column(columnDefinition = "TEXT")
    private String bio;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private AcademicDegree academicDegree;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private AcademicRank academicRank;

    @Setter
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

}
