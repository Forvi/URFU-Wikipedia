package com.example.WikiUrfu.DTOs;

import com.example.WikiUrfu.entity.AcademicDegree;
import com.example.WikiUrfu.entity.AcademicRank;
import com.example.WikiUrfu.entity.DepartmentEntity;

public class AddToDepartmentRequestDto {
    private String name;
    private String bio;
    private AcademicDegree academicDegree;
    private AcademicRank academicRank;
    private DepartmentEntity department;

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

    public AddToDepartmentRequestDto(DepartmentEntity department) {
        this.department = department;
    }

    public DepartmentEntity getDepartment(DepartmentEntity department) {
        return department;
    }

    @Override
    public String toString() {
        return "TeacherRequestDto [name=" + name + ", bio=" + bio + ", academicDegree=" + academicDegree
                + ", academicRank=" + academicRank + "]";
    }

    public DepartmentEntity getDepartment() {
        return department;
    }
}
