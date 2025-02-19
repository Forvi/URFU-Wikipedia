package com.example.WikiUrfu.DTOs;

import java.util.UUID;

public class DepartmentRequestDto {
    private String name;
    private String description;
    private UUID institiute_id;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public UUID getInstitiute_id() {
        return institiute_id;
    }

    public void setInstitiute_id(UUID institiute_id) {
        this.institiute_id = institiute_id;
    }

    @Override
    public String toString() {
        return "DepartmentRequestDto [name=" + name + ", description=" + description + "]";
    }

}
