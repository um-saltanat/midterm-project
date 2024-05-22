package com.example.midtermproject.dto;

import com.example.midtermproject.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private String username;
    private String email;
    private String phoneNumber;
    private Set<String> roles;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.roles = user.getRoles().stream().map(userRole -> userRole.getRolename().name()).collect(Collectors.toSet());
    }
}
