package com.example.WikiUrfu.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CreateInstituteRequestDto {

    @NotBlank(message = "Название института обязательно")
    @Size(max = 100, message = "Название института не должно превышать 100 символов")
    private String name;

    @Size(max = 1000, message = "Описание не должно превышать 1000 символов")
    private String description;
}
