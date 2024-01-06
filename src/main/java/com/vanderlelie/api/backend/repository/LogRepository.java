package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface LogRepository extends JpaRepository<Log, UUID> {
    List<Log> findByArchiverId(UUID archiverId);
}
