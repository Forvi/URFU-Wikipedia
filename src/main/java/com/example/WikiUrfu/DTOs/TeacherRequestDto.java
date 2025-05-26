package com.example.WikiUrfu.DTOs;

import java.util.UUID;

import com.example.WikiUrfu.entity.AcademicDegree;
import com.example.WikiUrfu.entity.AcademicRank;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

public class TeacherRequestDto {

    @Setter
    @Getter
    @Pattern(regexp = "^[А-Яа-яЁё\\s]+$", message = "Имя может содержать только буквы русского алфавита")
    @Size(min = 2, max = 50, message = "Некорректная длина")
    @NotEmpty(message = "Имя не может быть пустым")
    @NotNull()
    private String name;

    @Setter
    @Getter
    @Size(min = 2, max = 1000, message = "Некорректная длина")
    @NotNull()
    private String bio;

    @Setter
    @Getter
    private AcademicDegree academicDegree;

    @Setter
    @Getter
    private AcademicRank academicRank;

    @JsonProperty("department_id")
    private UUID department_id;

    TeacherRequestDto() {}

    public UUID getDepartmentId() {return department_id;}

    @Override
    public String toString() {
        return "TeacherRequestDto [name=" + name + ", bio=" + bio + ", academicDegree=" + academicDegree
                + ", academicRank=" + academicRank + "]";
    }
}
