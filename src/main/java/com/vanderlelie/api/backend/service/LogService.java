package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.Log;
import com.vanderlelie.api.backend.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public List<Log> findAllLogs() {
        return logRepository.findAll();
    }

    public Optional<Log> findLogById(UUID id) {
        return logRepository.findById(id);
    }

    public Log saveLog(Log log) {
        return logRepository.save(log);
    }

    public boolean deleteLog(UUID id) {
        if (logRepository.existsById(id)) {
            logRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Log> updateLog(UUID id, Log logDetails) {
        return logRepository.findById(id)
                .map(log -> {
                    // Update log fields here
                    log.setArchiverId(logDetails.getArchiverId());
                    log.setOrderId(logDetails.getOrderId());
                    // ... other fields
                    return logRepository.save(log);
                });
    }

    // Custom methods
    public List<Log> findLogsByArchiverId(UUID archiverId) {
        return logRepository.findByArchiverId(archiverId);
    }
}
