package com.fooddelivery.onlinefooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.UserRegisterRequest;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.response.ResponseStructure;
import com.fooddelivery.onlinefooddelivery.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    // Basic login with string message
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.authenticateUser(loginRequest);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Login with detailed response
    @PostMapping("/loginUserWithResponse")
    public ResponseEntity<ResponseStructure<User>> loginUserWithResponse(@RequestBody LoginRequest loginRequest) {
        User user = userService.validateUserCredentials(loginRequest);

        ResponseStructure<User> response = new ResponseStructure<>();
        response.setMsg(user.getName() + ", congratulations! You have successfully logged into your account.");
        response.setResponseId(HttpStatus.OK.value());
        response.setResponseData(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
