package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.CustomerSetting;
import com.vanderlelie.api.backend.repository.CustomerSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerSettingService {

    @Autowired
    private CustomerSettingRepository customerSettingRepository;

    public List<CustomerSetting> findAllCustomerSettings() {
        return customerSettingRepository.findAll();
    }

    public Optional<CustomerSetting> findCustomerSettingById(UUID id) {
        return customerSettingRepository.findById(id);
    }

    public CustomerSetting saveCustomerSetting(CustomerSetting customerSetting) {
        return customerSettingRepository.save(customerSetting);
    }

    public boolean deleteCustomerSetting(UUID id) {
        if (customerSettingRepository.existsById(id)) {
            customerSettingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<CustomerSetting> updateCustomerSetting(UUID id, CustomerSetting customerSettingDetails) {
        return customerSettingRepository.findById(id)
                .map(customerSetting -> {
                    // Update fields here
                    customerSetting.setName(customerSettingDetails.getName());
                    customerSetting.setNumber(customerSettingDetails.getNumber());
                    customerSetting.setText(customerSettingDetails.getText());
                    // ... other fields
                    return customerSettingRepository.save(customerSetting);
                });
    }

    public List<CustomerSetting> findCustomerSettingsByName(String name) {
        return customerSettingRepository.findByName(name);
    }

    // Additional custom methods if needed
}
