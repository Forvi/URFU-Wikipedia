package com.example.WikiUrfu.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.util.UUID;

public class DepartmentRequestDto {

    @NotEmpty(message = "Название кафедры не может быть пустым")
    @NotNull(message = "Название кафедры не может быть null")
    @Size(max = 50, message = "Название кафедры не может превышать 50 символов")
    @Pattern(regexp = "^[А-Яа-яЁё\\s]+$", message = "Название кафедры может содержать только буквы русского алфавита")

    private String name;
    private String description;

    @JsonProperty("institute_id")
    private UUID institute_id;

    public DepartmentRequestDto() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
     public UUID getInstituteId() {
        return institute_id;
    }

    @Override
    public String toString() {
        return "DepartmentRequestDto [name=" + name + ", description=" + description + "]";
    }

}
