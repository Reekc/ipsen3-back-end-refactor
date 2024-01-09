package com.vanderlelie.api.backend.controller;

import com.vanderlelie.api.backend.model.Setting;
import com.vanderlelie.api.backend.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/settings")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping
    public List<Setting> getAllSettings() {
        return settingService.findAllSettings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setting> getSettingById(@PathVariable UUID id) {
        return settingService.findSettingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Setting createSetting(@RequestBody Setting setting) {
        return settingService.saveOrUpdateSetting(setting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Setting> updateSetting(@PathVariable UUID id, @RequestBody Setting settingDetails) {
        return settingService.updateSetting(id, settingDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable UUID id) {
        if (settingService.deleteSetting(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
