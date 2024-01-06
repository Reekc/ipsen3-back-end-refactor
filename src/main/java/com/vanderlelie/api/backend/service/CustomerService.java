package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.Customer;
import com.vanderlelie.api.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    public Customer saveOrUpdateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean deleteCustomer(UUID id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Customer> updateCustomer(UUID id, Customer customerDetails) {
        return customerRepository.findById(id)
                .map(customer -> {
                    // Update fields of the customer here
                    customer.setName(customerDetails.getName());
                    customer.setVisitAddress(customerDetails.getVisitAddress());
                    customer.setDeliveryAddress(customerDetails.getDeliveryAddress());
                    // ... other fields
                    return customerRepository.save(customer);
                });
    }

    // Custom methods
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer findCustomerByCustomerNumber(int customerNumber) {
        return customerRepository.findByCustomerNumber(customerNumber);
    }
}
