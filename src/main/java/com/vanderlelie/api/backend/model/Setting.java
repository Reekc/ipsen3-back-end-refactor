package com.vanderlelie.api.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
@Table(name = "setting")
public class Setting {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 255)
    private String name;

    private Integer number;
    private Boolean toggled;
    private String text;

    public Setting() {

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

    public Boolean getToggled() {
        return toggled;
    }

    public void setToggled(Boolean toggled) {
        this.toggled = toggled;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Setting(UUID id, String name, Integer number, Boolean toggled, String text) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.toggled = toggled;
        this.text = text;
    }
}
