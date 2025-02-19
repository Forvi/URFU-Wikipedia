package com.example.WikiUrfu.DTOs;

import java.util.UUID;

import com.example.WikiUrfu.entity.AcademicDegree;
import com.example.WikiUrfu.entity.AcademicRank;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class TeacherRequestDto {

    @Pattern(regexp = "^[А-Яа-яЁё\\s]+$", message = "Имя может содержать только буквы русского алфавита")
    @Size(min = 2, max = 50, message = "Некорректная длина")
    @NotEmpty(message = "Имя не может быть пустым")
    @NotNull()
    private String name;

    @Size(min = 2, max = 1000, message = "Некорректная длина")
    @NotNull()
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
