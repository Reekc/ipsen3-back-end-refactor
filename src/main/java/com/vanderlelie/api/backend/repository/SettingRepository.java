package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface SettingRepository extends JpaRepository<Setting, UUID> {
    List<Setting> findByName(String name);
}
