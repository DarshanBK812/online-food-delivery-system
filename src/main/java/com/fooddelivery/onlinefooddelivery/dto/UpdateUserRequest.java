package com.fooddelivery.onlinefooddelivery.dto;

public class UpdateUserRequest {

	private LoginRequest loginRequest;
	private UserRegisterRequest registerRequest;
	public LoginRequest getLoginRequest() {
		return loginRequest;
	}
	public void setLoginRequest(LoginRequest loginRequest) {
		this.loginRequest = loginRequest;
	}
	public UserRegisterRequest getRegisterRequest() {
		return registerRequest;
	}
	public void setRegisterRequest(UserRegisterRequest registerRequest) {
		this.registerRequest = registerRequest;
	}
	
	

}
