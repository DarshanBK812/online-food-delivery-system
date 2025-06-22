package com.fooddelivery.onlinefooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.response.UserResponse;
import com.fooddelivery.onlinefooddelivery.service.UserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	UserService userService;

	@PostMapping("/dashboard")
	public ResponseEntity<?> customerDashBoard(@RequestBody LoginRequest loginRequest) {

		User user = userService.validateUserCredentials(loginRequest);
		if (!user.getRole().equalsIgnoreCase("customer")) {
			ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied ! : Customers Only");
		}

		UserResponse response = new UserResponse(
				"Welcome to Customer Dashboard! " + user.getName() + ", you have logged in successfully as "
						+ user.getRole() + ". Please check details below:",
				user.getName(), user.getEmail(), user.getRole());

		return ResponseEntity.ok(response);

	}

}
