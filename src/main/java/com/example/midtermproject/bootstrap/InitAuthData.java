package com.example.midtermproject.bootstrap;

import com.example.midtermproject.entities.User;
import com.example.midtermproject.entities.UserRole;
import com.example.midtermproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitAuthData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            initDefaultUsers();
        }
    }

    private void initDefaultUsers() {
        User user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .email("user@example.com")
                .roles(Set.of(UserRole.user))
                .build();

        User staff = User.builder()
                .username("staff")
                .password(passwordEncoder.encode("password"))
                .email("staff@example.com")
                .roles(Set.of(UserRole.staff))
                .build();

        User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .email("admin@example.com")
                .roles(Set.of(UserRole.admin, UserRole.staff))
                .build();

        userRepository.saveAll(List.of(user, staff, admin));
    }
}
