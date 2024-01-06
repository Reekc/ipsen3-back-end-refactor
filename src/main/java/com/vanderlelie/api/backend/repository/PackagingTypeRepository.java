package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.PackagingType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface PackagingTypeRepository extends JpaRepository<PackagingType, UUID> {
    List<PackagingType> findByName(String name);
}
