package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.PackagingType;
import com.vanderlelie.api.backend.repository.PackagingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PackagingTypeService {

    @Autowired
    private PackagingTypeRepository packagingTypeRepository;

    public List<PackagingType> findAllPackagingTypes() {
        return packagingTypeRepository.findAll();
    }

    public Optional<PackagingType> findPackagingTypeById(UUID id) {
        return packagingTypeRepository.findById(id);
    }

    public PackagingType saveOrUpdatePackagingType(PackagingType packagingType) {
        return packagingTypeRepository.save(packagingType);
    }

    public boolean deletePackagingType(UUID id) {
        if (packagingTypeRepository.existsById(id)) {
            packagingTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<PackagingType> updatePackagingType(UUID id, PackagingType packagingTypeDetails) {
        return packagingTypeRepository.findById(id)
                .map(packagingType -> {
                    // Update fields of the packaging type here
                    packagingType.setName(packagingTypeDetails.getName());
                    // ... other fields
                    return packagingTypeRepository.save(packagingType);
                });
    }

    // Additional custom methods if needed
}
