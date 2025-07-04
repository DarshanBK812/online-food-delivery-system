package com.fooddelivery.onlinefooddelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.UserRegisterRequest;
import com.fooddelivery.onlinefooddelivery.entity.Order;
import com.fooddelivery.onlinefooddelivery.entity.User;

public interface UserService {

	ResponseEntity<?> registerUser(UserRegisterRequest userRequest);

	boolean authenticateUser(LoginRequest loginRequest);

	User validateUserCredentials(LoginRequest loginRequest);

	public List<User> fetchAllTheCustomerByAdmin(LoginRequest loginRequest);

	public User updateUserBycredentials(LoginRequest loginRequest, UserRegisterRequest registerRequest);

	public User deleteAccountByCredentials(LoginRequest loginRequest);

}
