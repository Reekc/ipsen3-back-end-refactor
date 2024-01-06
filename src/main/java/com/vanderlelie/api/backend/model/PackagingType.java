package com.vanderlelie.api.backend.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "packaging_type")
public class PackagingType {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 255)
    private String name;

    // Constructors, Getters, and Setters

    public PackagingType(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public PackagingType() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
