package com.example.WikiUrfu.DTOs;

import java.util.UUID;

import com.example.WikiUrfu.entity.AcademicDegree;
import com.example.WikiUrfu.entity.AcademicRank;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TeacherRequestDto {
    private String name;
    private String bio;
    private AcademicDegree academicDegree;
    private AcademicRank academicRank;

    @JsonProperty("department_id")
    private UUID department_id;

    TeacherRequestDto() {}

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public AcademicRank getAcademicRank() {
        return academicRank;
    }

    public UUID getDepartmentId() {
        return department_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setAcademicRank(AcademicRank academicRank) {
        this.academicRank = academicRank;
    }

    @Override
    public String toString() {
        return "TeacherRequestDto [name=" + name + ", bio=" + bio + ", academicDegree=" + academicDegree
                + ", academicRank=" + academicRank + "]";
    }
}
