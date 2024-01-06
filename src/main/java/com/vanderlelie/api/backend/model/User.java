package com.vanderlelie.api.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Entity
@Table(name = "\"user\"")  // Use quotes because "user" is a reserved keyword
public class User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 255)
    private String username;

    @Column(columnDefinition = "TEXT")
    private String password;

    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Column(name = "permission_bit", nullable = false)
    private int permissionBit;

    @Column(nullable = false)
    private boolean admin;

    public User() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPermissionBit() {
        return permissionBit;
    }

    public void setPermissionBit(int permissionBit) {
        this.permissionBit = permissionBit;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public User(UUID id, String username, String password, String firstName, String lastName, int permissionBit, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.permissionBit = permissionBit;
        this.admin = admin;
    }
    // Constructors, getters and setters
}
