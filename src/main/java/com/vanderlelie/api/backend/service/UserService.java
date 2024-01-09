package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.User;
import com.vanderlelie.api.backend.repository.UserRepository;
import io.micrometer.observation.ObservationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    public User saveOrUpdateUser(User user, String encodedPassword) {
        user.setPassword(encodedPassword); // Use the already encoded password
        return userRepository.save(user);
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(UUID id, User userDetails) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    // Update the fields of the existing user
                    existingUser.setUsername(userDetails.getUsername());
                    existingUser.setPassword(userDetails.getPassword());
                    existingUser.setFirstName(userDetails.getFirstName());
                    existingUser.setLastName(userDetails.getLastName());
                    existingUser.setPermissionBit(userDetails.getPermissionBit());
                    existingUser.setAdmin(userDetails.isAdmin());
                    // Add other fields if necessary
                    return userRepository.save(existingUser);
                });
    }

    public boolean deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Additional methods
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findUsersByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public List<User> findUsersByAdmin(boolean isAdmin) {
        return userRepository.findByAdmin(isAdmin);
    }

}
