package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    List<Customer> findByName(String name);
    Customer findByEmail(String email);
    Customer findByCustomerNumber(int customerNumber);
}
