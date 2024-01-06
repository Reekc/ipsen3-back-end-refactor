package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByOrderId(UUID orderId);
    List<Product> findByProductTypeId(UUID productTypeId);
}
