package com.example.Eagle.UserManagement.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    public UserModel userModel;
    @Autowired
    public UserController(UserModel userModel) {
        this.userModel = userModel;
    }

    @GetMapping("/getall")
    public List<User> getAllUsers() {
        return userModel.getAll();
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return userModel.update(user);
    }
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username){
        return userModel.delete(username);
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        return userModel.get(username);
    }
}
