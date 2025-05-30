package com.example.WikiUrfu.DTOs;

import com.example.WikiUrfu.entity.AcademicDegree;
import com.example.WikiUrfu.entity.AcademicRank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToDepartmentRequestDto {
    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @NotBlank(message = "Биография не может быть пустой")
    private String bio;

    @NotNull(message = "Ученая степень обязательна")
    private AcademicDegree academicDegree;

    @NotNull(message = "Ученое звание обязательно")
    private AcademicRank academicRank;
}