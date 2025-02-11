package com.example.WikiUrfu.entity;


import jakarta.persistence.*;
import jdk.jfr.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "institutes")
public class InstitutesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institute", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DepartmentEntity> departments = new ArrayList<>();

    public InstitutesEntity() {

    }

    public InstitutesEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
