package com.vanderlelie.api.backend.service;

import com.vanderlelie.api.backend.model.User;
import com.vanderlelie.api.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
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
