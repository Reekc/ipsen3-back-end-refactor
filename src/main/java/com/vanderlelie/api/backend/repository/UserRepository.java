package com.vanderlelie.api.backend.repository;

import com.vanderlelie.api.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    List<User> findByLastName(String lastName);
    List<User> findByAdmin(boolean isAdmin);
}
