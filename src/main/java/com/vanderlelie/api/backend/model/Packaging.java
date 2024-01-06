package com.vanderlelie.api.backend.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "packaging")
public class Packaging {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "packaging_type", nullable = false)
    private UUID packagingTypeId;

    private String name;
    private Integer width;
    private Integer height;
    private Integer length;
    private Integer amount;
    private String location;
    @Column(name = "minimum_stock")
    private Integer minimumStock;
    private String company;

    public Packaging() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
// Constructors, Getters, Setters

    public Packaging(UUID id, UUID packagingTypeId, String name, Integer width, Integer height, Integer length, Integer amount, String location, Integer minimumStock, String company) {
        this.id = id;
        this.packagingTypeId = packagingTypeId;
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.amount = amount;
        this.location = location;
        this.minimumStock = minimumStock;
        this.company = company;
    }
}
