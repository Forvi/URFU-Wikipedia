package com.example.WikiUrfu.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table (name = "institutes")
public class InstituteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Setter
    @Column(length = 255, nullable = false)
    private String name;

    @Setter
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "institute", orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<DepartmentEntity> departments = new ArrayList<>();

    public InstituteEntity() {
    }

    public InstituteEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
