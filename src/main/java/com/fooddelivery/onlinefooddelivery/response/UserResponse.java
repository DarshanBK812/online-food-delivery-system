package com.fooddelivery.onlinefooddelivery.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

	private String message;
	private String name;
	private String email;
	private String role;

	public UserResponse(String message, String name, String email, String role) {

		this.message = message;
		this.name = name;
		this.email = email;
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
