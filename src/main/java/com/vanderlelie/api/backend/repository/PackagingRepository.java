package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.Packaging;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface PackagingRepository extends JpaRepository<Packaging, UUID> {
    List<Packaging> findByPackagingTypeId(UUID packagingTypeId);
}
