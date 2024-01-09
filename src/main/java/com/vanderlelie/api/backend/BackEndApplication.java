package com.vanderlelie.api.backend;

import com.vanderlelie.api.backend.model.User;
import com.vanderlelie.api.backend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User();
            user.setUsername("Robin1");
            user.setFirstName("Robin");
            user.setLastName("Putten");
            user.setAdmin(true);
            user.setPermissionBit(1953914874);
            user.setId(UUID.fromString("54ffbd43-ab3f-432e-b810-07ce155a9f95"));

            // Encode the password before saving the user
            String encodedPassword = passwordEncoder.encode("1234");
            userService.saveOrUpdateUser(user, encodedPassword);

            System.out.println(user);
        };
    }
}


