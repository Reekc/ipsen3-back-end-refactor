package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.CustomerSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface CustomerSettingRepository extends JpaRepository<CustomerSetting, UUID> {
    List<CustomerSetting> findByName(String name);
}
