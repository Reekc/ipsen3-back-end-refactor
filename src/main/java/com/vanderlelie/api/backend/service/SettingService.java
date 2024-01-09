package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.Setting;
import com.vanderlelie.api.backend.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingService {

    @Autowired
    private SettingRepository settingRepository;

    public List<Setting> findAllSettings() {
        return settingRepository.findAll();
    }

    public Optional<Setting> findSettingById(UUID id) {
        return settingRepository.findById(id);
    }

    public Setting saveOrUpdateSetting(Setting setting) {
        return settingRepository.save(setting);
    }

    public boolean deleteSetting(UUID id) {
        if (settingRepository.existsById(id)) {
            settingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Setting> updateSetting(UUID id, Setting settingDetails) {
        return settingRepository.findById(id)
                .map(setting -> {
                    // Update fields of the setting here
                    setting.setName(settingDetails.getName());
                    setting.setNumber(settingDetails.getNumber());
                    setting.setToggled(settingDetails.getToggled());
                    setting.setText(settingDetails.getText());
                    // ... other fields
                    return settingRepository.save(setting);
                });
    }

    // Custom methods
    public List<Setting> findSettingsByName(String name) {
        return settingRepository.findByName(name);
    }

}
