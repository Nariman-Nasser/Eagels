package com.example.Eagle.UserManagement.AuthenticationService.Authentication;


import com.example.Eagle.UserManagement.Role.Role;
import com.example.Eagle.UserManagement.User.User;
import com.example.Eagle.UserManagement.User.UserRepository;
import com.example.Eagle.UserManagement.User.User;

import com.example.Eagle.UserManagement.AuthenticationService.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;


    public AuthenticationResponse register(com.example.Eagle.UserManagement.AuthenticationService.Authentication.RegisterRequest request) throws ExecutionException, InterruptedException {
        var user = userRepository.findByUsername(request.getUsername()).orElse(null);
        if (user != null) {
            return AuthenticationResponse.builder()
                    .token(null)
                    .message("User already exists")
                    .Status(402)
                    .build();
        }
        user= userRepository.findByEmail(request.getEmail()).orElse(null);
        if (user != null) {
            return AuthenticationResponse.builder()
                    .token(null)
                    .message("Email already exists")
                    .Status(403)
                    .build();
        }

        if(request.getPassword().length()<=8){
            return AuthenticationResponse.builder()
                    .token(null)
                    .message("Password must be at least 8 characters long")
                    .Status(405)
                    .build();
        }
        var newUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .email(request.getEmail())
                .role(request.getRole())
                .build();


        userRepository.save(newUser);
        var jwtToken = jwtService.generateToken(newUser);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("success")
                .Status(200)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request)
            throws ExecutionException, InterruptedException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
           var user = userRepository.findByUsername(request.getUsername()).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("success")
                .Status(200)
                .build();
    }
}

