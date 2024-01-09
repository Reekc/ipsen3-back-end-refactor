package com.vanderlelie.api.backend.controller;

import com.vanderlelie.api.backend.model.ProductType;
import com.vanderlelie.api.backend.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-types")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public List<ProductType> getAllProductTypes() {
        return productTypeService.findAllProductTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable UUID id) {
        return productTypeService.findProductTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductType createProductType(@RequestBody ProductType productType) {
        return productTypeService.saveOrUpdateProductType(productType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductType> updateProductType(@PathVariable UUID id, @RequestBody ProductType productTypeDetails) {
        return productTypeService.updateProductType(id, productTypeDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductType(@PathVariable UUID id) {
        if (productTypeService.deleteProductType(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
