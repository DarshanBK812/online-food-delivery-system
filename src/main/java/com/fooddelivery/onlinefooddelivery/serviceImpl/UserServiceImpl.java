package com.fooddelivery.onlinefooddelivery.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.UserRegisterRequest;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.exception.ExistedUser;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.response.UserResponse;
import com.fooddelivery.onlinefooddelivery.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public ResponseEntity<?> registerUser(UserRegisterRequest userRequest) {

		if (userRepo.existsByEmail(userRequest.getEmail())) {
			throw new ExistedUser(userRequest.getName() + " User has already Existed Please change the email");
		}

		User user = new User();
		user.setName(userRequest.getName().toLowerCase());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setRole(userRequest.getRole().toLowerCase());

		UserResponse loginResponse = new UserResponse("Register successfully please check the details below : ",
				userRequest.getName(), userRequest.getEmail(), userRequest.getRole());

		userRepo.save(user);
		return ResponseEntity.ok(loginResponse);

	}

	@Override
	public boolean authenticateUser(LoginRequest loginRequest) {
		Optional<User> user = userRepo.findByEmail(loginRequest.getEmail());
		return user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword());

	}

	// Just to check user present in the database if does return user details
	@Override
	public User validateUserCredentials(LoginRequest loginRequest) {
		Optional<User> user = userRepo.findByEmail(loginRequest.getEmail());

		if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
			return user.get();
		} else {
			throw new NotFoundException("Account not found Plz check the credential  ");
		}

	}

	// To check the customers who registered
	@Override
	public List<User> fetchAllTheCustomerByAdmin(LoginRequest loginRequest) {
		Optional<User> admin = userRepo.findByEmail(loginRequest.getEmail());
		if (!admin.isPresent() || !admin.get().getPassword().equals(loginRequest.getPassword())
				|| !admin.get().getRole().equalsIgnoreCase("admin")) {
			throw new NotFoundException(
					"Please check the mail or password or your nor authorized to access the this details");
		}

		List<User> users = userRepo.findAll();
		List<User> customers = new ArrayList<User>();
		for (User user : users) {
			if (user.getRole().equalsIgnoreCase("customer")) {
				customers.add(user);
			}
		}

		return customers;

	}

	// update the user by using thier credentials
	public User updateUserBycredentials(LoginRequest loginRequest, UserRegisterRequest registerRequest) {

		User user = validateUserCredentials(loginRequest);

		int oldId = user.getId();
		user.setId(oldId);
		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		user.setRole(registerRequest.getRole());

		return userRepo.save(user);

	}

	// Delete account by credetial
	public User deleteAccountByCredentials(LoginRequest loginRequest) {

		Optional<User> user = userRepo.findByEmail(loginRequest.getEmail());

		if (user.isEmpty() || !loginRequest.getPassword().equals(user.get().getPassword())) {
			throw new NotFoundException("No user found plz check the credentials");
		}

		userRepo.delete(user.get());
		return user.get();

	}

}
