package com.example.Eagle.UserManagement.AuthenticationService.Authentication;

import com.example.Eagle.UserManagement.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String photo;
    @Enumerated(EnumType.STRING)
    private Role role;

}