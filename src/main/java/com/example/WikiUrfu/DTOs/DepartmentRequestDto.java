package com.example.WikiUrfu.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class DepartmentRequestDto {
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
