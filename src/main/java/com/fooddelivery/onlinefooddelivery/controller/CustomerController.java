package com.fooddelivery.onlinefooddelivery.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.UpdateUserRequest;
import com.fooddelivery.onlinefooddelivery.dto.UserRegisterRequest;
import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.Restaurant;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.response.FoodResponseForCustumer;
import com.fooddelivery.onlinefooddelivery.response.ResponseStructure;
import com.fooddelivery.onlinefooddelivery.response.RestuarantFoodInfoResponse;
import com.fooddelivery.onlinefooddelivery.response.UserResponse;
import com.fooddelivery.onlinefooddelivery.service.CustomerService;
import com.fooddelivery.onlinefooddelivery.service.UserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	UserService userService;

	@Autowired
	CustomerService customerService;

	@PostMapping("/dashboard")
	public ResponseEntity<?> customerDashBoard(@RequestBody LoginRequest loginRequest) {

		User user = userService.validateUserCredentials(loginRequest);
		if (!user.getRole().equalsIgnoreCase("customer")) {
			ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied ! : Customers Only");
		}

		UserResponse response = new UserResponse(
				user.getRole() + " " + " Welcome to Dashboard! " + user.getName()
						+ ", you have logged in successfully as " + user.getRole() + ". Please check details below:",
				user.getName(), user.getEmail(), user.getRole());

		return ResponseEntity.ok(response);

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

	@PostMapping("/deleteAccountByCredentials")
	public ResponseEntity<?> deleteAccountByCredentials(@RequestBody LoginRequest loginRequest) {

		userService.deleteAccountByCredentials(loginRequest);

		return ResponseEntity.ok("Account has been deleted from the DB");
	}

	@GetMapping("/fetchFoodItemsByName")
	public ResponseEntity<ResponseStructure<List<RestuarantFoodInfoResponse>>> fetchFoodItemsByName(@RequestParam String foodName) {
	    List<RestuarantFoodInfoResponse> responseData = customerService.fetchRestaurantByName(foodName);

	    ResponseStructure<List<RestuarantFoodInfoResponse>> response = new ResponseStructure<>();
	    response.setMsg(foodName + " is available in below restaurants");
	    response.setResponseId(HttpStatus.OK.value());
	    response.setResponseData(responseData); // ✅ set the actual data

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}


	// Get all orders for user
//	public 

}
