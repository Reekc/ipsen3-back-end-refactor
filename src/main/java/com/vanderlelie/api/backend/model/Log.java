package com.vanderlelie.api.backend.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "archiver")
    private UUID archiverId;

    @Column(name = "order_id")
    private UUID orderId;

    public Log() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getArchiverId() {
        return archiverId;
    }

    public void setArchiverId(UUID archiverId) {
        this.archiverId = archiverId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
// Constructors, Getters, Setters

    public Log(UUID id, UUID archiverId, UUID orderId) {
        this.id = id;
        this.archiverId = archiverId;
        this.orderId = orderId;
    }
}
