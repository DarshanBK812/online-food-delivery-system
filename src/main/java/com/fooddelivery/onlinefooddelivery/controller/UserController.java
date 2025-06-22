package com.fooddelivery.onlinefooddelivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.UpdateUserRequest;
import com.fooddelivery.onlinefooddelivery.dto.UserRegisterRequest;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.response.UserResponse;
import com.fooddelivery.onlinefooddelivery.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

//	@Autowired
//	LoginResponse loginResponse;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterRequest userRequest) {

		userService.registerUser(userRequest);

		UserResponse loginResponse = new UserResponse("Register successfully please check the details below : ",
				userRequest.getName(), userRequest.getEmail(), userRequest.getRole());
		return ResponseEntity.ok(loginResponse);

	}

	// To check the credential of user when he login to app with no proper response
	// structure
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
		boolean isAuthenticated = userService.authenticateUser(loginRequest);
		if (isAuthenticated) {
			return ResponseEntity.ok("Login successfully");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}

	// customer Login with proper response
	@PostMapping("/login2")
	public ResponseEntity<?> loginUser2(@RequestBody LoginRequest loginRequest) {

		User user = userService.validateUserCredentials(loginRequest);

		UserResponse loginResponse = new UserResponse("Login successfully", user.getName(), user.getEmail(),
				user.getRole());
		return ResponseEntity.ok(loginResponse);

	}

	// Update user account Bycredentials(email and password)

	@PostMapping("/updateUserBycredentials")
	public ResponseEntity<?> updateUserBycredentials(@RequestBody UpdateUserRequest updateUserRequest) {

		LoginRequest loginRequest = updateUserRequest.getLoginRequest();
		UserRegisterRequest registerRequest = updateUserRequest.getRegisterRequest();

		userService.updateUserBycredentials(loginRequest, registerRequest);

		UserResponse userResponse = new UserResponse("Update successfully : ", registerRequest.getName(),
				registerRequest.getEmail(), registerRequest.getRole());

		return ResponseEntity.ok(userResponse);

	}

}
