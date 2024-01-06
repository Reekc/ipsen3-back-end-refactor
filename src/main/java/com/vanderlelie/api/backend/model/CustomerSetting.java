package com.vanderlelie.api.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "customer_setting")
public class CustomerSetting {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Integer number;
    private String text;

    public CustomerSetting(UUID id, String name, Integer number, String text) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.text = text;
    }

    public CustomerSetting() {

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
// Constructors, Getters, Setters
}
