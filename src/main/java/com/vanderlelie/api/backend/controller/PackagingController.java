package com.vanderlelie.api.backend.controller;

import com.vanderlelie.api.backend.model.Packaging;
import com.vanderlelie.api.backend.service.PackagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/packaging")
public class PackagingController {

    @Autowired
    private PackagingService packagingService;

    @GetMapping
    public List<Packaging> getAllPackaging() {
        return packagingService.findAllPackaging();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Packaging> getPackagingById(@PathVariable UUID id) {
        return packagingService.findPackagingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Packaging createPackaging(@RequestBody Packaging packaging) {
        return packagingService.savePackaging(packaging);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Packaging> updatePackaging(@PathVariable UUID id, @RequestBody Packaging packagingDetails) {
        return packagingService.updatePackaging(id, packagingDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePackaging(@PathVariable UUID id) {
        if (packagingService.deletePackaging(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
