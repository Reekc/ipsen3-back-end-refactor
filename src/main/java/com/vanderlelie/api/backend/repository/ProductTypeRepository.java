package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, UUID> {
    List<ProductType> findByPackagingTypeId(UUID packagingTypeId);
}
