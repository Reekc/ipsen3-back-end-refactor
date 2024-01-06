package com.vanderlelie.api.backend.controller;

import com.vanderlelie.api.backend.model.CustomerSetting;
import com.vanderlelie.api.backend.service.CustomerSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer-settings")
public class CustomerSettingController {

    @Autowired
    private CustomerSettingService customerSettingService;

    @GetMapping
    public List<CustomerSetting> getAllCustomerSettings() {
        return customerSettingService.findAllCustomerSettings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerSetting> getCustomerSettingById(@PathVariable UUID id) {
        return customerSettingService.findCustomerSettingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CustomerSetting createCustomerSetting(@RequestBody CustomerSetting customerSetting) {
        return customerSettingService.saveCustomerSetting(customerSetting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerSetting> updateCustomerSetting(@PathVariable UUID id, @RequestBody CustomerSetting customerSettingDetails) {
        return customerSettingService.updateCustomerSetting(id, customerSettingDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerSetting(@PathVariable UUID id) {
        if (customerSettingService.deleteCustomerSetting(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
