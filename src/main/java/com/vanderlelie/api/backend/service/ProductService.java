package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.Product;
import com.vanderlelie.api.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(UUID id) {
        return productRepository.findById(id);
    }

    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProduct(UUID id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Product> updateProduct(UUID id, Product productDetails) {
        return productRepository.findById(id)
                .map(product -> {
                    // Update fields of the product here
                    product.setOrderId(productDetails.getOrderId());
                    product.setProductTypeId(productDetails.getProductTypeId());
                    product.setPackagingId(productDetails.getPackagingId());
                    // ... other fields
                    return productRepository.save(product);
                });
    }

    // Custom methods
    public List<Product> findProductsByOrderId(UUID orderId) {
        return productRepository.findByOrderId(orderId);
    }

    public List<Product> findProductsByProductTypeId(UUID productTypeId) {
        return productRepository.findByProductTypeId(productTypeId);
    }
}
