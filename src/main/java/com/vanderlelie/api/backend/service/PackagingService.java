package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.Packaging;
import com.vanderlelie.api.backend.repository.PackagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PackagingService {

    @Autowired
    private PackagingRepository packagingRepository;

    public List<Packaging> findAllPackagings() {
        return packagingRepository.findAll();
    }

    public Optional<Packaging> findPackagingById(UUID id) {
        return packagingRepository.findById(id);
    }

    public Packaging saveOrUpdatePackaging(Packaging packaging) {
        return packagingRepository.save(packaging);
    }

    public boolean deletePackaging(UUID id) {
        if (packagingRepository.existsById(id)) {
            packagingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Packaging> updatePackaging(UUID id, Packaging packagingDetails) {
        return packagingRepository.findById(id)
                .map(packaging -> {

                    packaging.setName(packagingDetails.getName());
                    packaging.setPackagingTypeId(packagingDetails.getPackagingTypeId());

                    return packagingRepository.save(packaging);
                });
    }

    // Custom methods
    public List<Packaging> findPackagingsByPackagingTypeId(UUID packagingTypeId) {
        return packagingRepository.findByPackagingTypeId(packagingTypeId);
    }
}
