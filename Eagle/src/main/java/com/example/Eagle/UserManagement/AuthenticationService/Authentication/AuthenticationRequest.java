package com.example.Eagle.UserManagement.AuthenticationService.Authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AuthenticationRequest {
    private String username;
    private String password;
}
