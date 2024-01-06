package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByCustomerId(UUID customerId);
    List<Order> findByUserId(UUID userId);
}
