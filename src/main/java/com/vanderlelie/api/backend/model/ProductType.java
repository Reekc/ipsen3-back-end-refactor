package com.vanderlelie.api.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
@Table(name = "product_type")
public class ProductType {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "packaging_type", nullable = false)
    private UUID packagingTypeId;

    // Constructors, Getters, Setters

    public ProductType(UUID id, UUID packagingTypeId) {
        this.id = id;
        this.packagingTypeId = packagingTypeId;
    }

    public ProductType() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPackagingTypeId() {
        return packagingTypeId;
    }

    public void setPackagingTypeId(UUID packagingTypeId) {
        this.packagingTypeId = packagingTypeId;
    }


}
