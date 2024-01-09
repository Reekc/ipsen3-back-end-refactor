package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.ProductType;
import com.vanderlelie.api.backend.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> findAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public Optional<ProductType> findProductTypeById(UUID id) {
        return productTypeRepository.findById(id);
    }

    public ProductType saveOrUpdateProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public boolean deleteProductType(UUID id) {
        if (productTypeRepository.existsById(id)) {
            productTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<ProductType> updateProductType(UUID id, ProductType productTypeDetails) {
        return productTypeRepository.findById(id)
                .map(productType -> {
                    // Update fields of the product type here
                    productType.setPackagingTypeId(productTypeDetails.getPackagingTypeId());
                    // ... other fields
                    return productTypeRepository.save(productType);
                });
    }

    // Custom methods
    public List<ProductType> findProductTypesByPackagingTypeId(UUID packagingTypeId) {
        return productTypeRepository.findByPackagingTypeId(packagingTypeId);
    }
}
