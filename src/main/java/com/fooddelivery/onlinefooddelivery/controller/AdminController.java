package com.fooddelivery.onlinefooddelivery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.response.UserResponse;
import com.fooddelivery.onlinefooddelivery.response.fetchUsersByAdressResposnce;
import com.fooddelivery.onlinefooddelivery.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;

	@PostMapping("/dashboard")
	public ResponseEntity<?> adminDashboard(@RequestBody LoginRequest loginRequest) {

		User user = userService.validateUserCredentials(loginRequest);
		if (!user.getRole().equalsIgnoreCase("admin")) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied: Admins only");
		}

		UserResponse response = new UserResponse(
				"Welcome to Admin Dashboard! " + user.getName() + ", you have logged in successfully as "
						+ user.getRole() + ". Please check details below:",
				user.getName(), user.getEmail(), user.getRole());

		return ResponseEntity.ok(response);
	}

	// Fetch all the customer By admine
	@PostMapping("/getCustomerDetails")
	public ResponseEntity<?> fetchAllTheCustomerByAdmin(@RequestBody LoginRequest loginRequest) {

		if (!userService.authenticateUser(loginRequest)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied: Admins only");
		}

		List<User> user = userService.fetchAllTheCustomerByAdmin(loginRequest);

		List<String> customers = new ArrayList<String>();

		for (User user2 : user) {
			customers.add(user2.getName());
		}

		fetchUsersByAdressResposnce fetchUsersByAdressResposnce = new fetchUsersByAdressResposnce();
		fetchUsersByAdressResposnce.setMsg("Customers available in the DB");
		fetchUsersByAdressResposnce.setNames(customers);

		return ResponseEntity.ok(fetchUsersByAdressResposnce);
	}

}
