package com.example.WikiUrfu.DTOs;

import com.example.WikiUrfu.entity.AcademicDegree;
import com.example.WikiUrfu.entity.AcademicRank;
import com.example.WikiUrfu.entity.DepartmentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
public class AddToDepartmentRequestDto {
    @Setter
    private String name;
    @Setter
    private String bio;
    @Setter
    private AcademicDegree academicDegree;
    @Setter
    private AcademicRank academicRank;
    private DepartmentEntity department;

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

}
