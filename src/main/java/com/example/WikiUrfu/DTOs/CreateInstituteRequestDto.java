package com.example.WikiUrfu.DTOs;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateInstituteRequestDto {
    private String name;
    private String description;

    @Override
    public String toString() {
        return "CreateInstituteRequestDto{" + "name='" + name + '\'' + ", description='" + description + '\'' + '}';
    }
}
