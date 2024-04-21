package com.example.Eagle.UserManagement.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserModel {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserModel(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    //update user
    public ResponseEntity<?> update(User user) {
       //check if user exist
         User existingUser = userRepository.findByUsername(user.getEmail()).orElse(null);
            if(existingUser == null) {
                return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
            }
            else {
                 existingUser.setFullName(user.getFullName());
                 existingUser.setUsername(user.getUsername());
                    if(!user.getPassword().equalsIgnoreCase(existingUser.getPassword())){
                        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
                    }

                    userRepository.save(existingUser);

                return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
            }
    }
    public ResponseEntity<?> delete(String username) {
        User existingUser = userRepository.findByUsername(username).orElse(null);
        if(existingUser == null) {
            return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
        }
        else {
            userRepository.delete(existingUser);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        }
    }
    public ResponseEntity<?> get(String Email) {
        User existingUser = userRepository.findByEmail( Email).orElse(null);
        if(existingUser == null) {
            return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        }
    }
}
