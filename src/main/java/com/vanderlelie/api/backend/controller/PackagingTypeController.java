package com.vanderlelie.api.backend.controller;

import com.vanderlelie.api.backend.model.PackagingType;
import com.vanderlelie.api.backend.service.PackagingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/packaging-types")
public class PackagingTypeController {

    @Autowired
    private PackagingTypeService packagingTypeService;

    @GetMapping
    public List<PackagingType> getAllPackagingTypes() {
        return packagingTypeService.findAllPackagingTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackagingType> getPackagingTypeById(@PathVariable UUID id) {
        return packagingTypeService.findPackagingTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PackagingType createPackagingType(@RequestBody PackagingType packagingType) {
        return packagingTypeService.saveOrUpdatePackagingType(packagingType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackagingType> updatePackagingType(@PathVariable UUID id, @RequestBody PackagingType packagingTypeDetails) {
        return packagingTypeService.updatePackagingType(id, packagingTypeDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePackagingType(@PathVariable UUID id) {
        if (packagingTypeService.deletePackagingType(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
