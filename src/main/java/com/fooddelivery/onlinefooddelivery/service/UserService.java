package com.fooddelivery.onlinefooddelivery.service;

import java.util.List;
import java.util.Optional;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.UserRegisterRequest;
import com.fooddelivery.onlinefooddelivery.entity.User;

public interface UserService {

	User registerUser(UserRegisterRequest userRequest);

	boolean authenticateUser(LoginRequest loginRequest);

	User validateUserCredentials(LoginRequest loginRequest);

	public List<User> fetchAllTheCustomerByAdmin(LoginRequest loginRequest);

	public User updateUserBycredentials(LoginRequest loginRequest, UserRegisterRequest registerRequest);

}
