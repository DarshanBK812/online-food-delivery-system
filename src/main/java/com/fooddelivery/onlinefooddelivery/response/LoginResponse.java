package com.fooddelivery.onlinefooddelivery.response;

public class LoginResponse {
    private String message;
    private String token;
    private String name;
    private String email;
    private String role;

    public LoginResponse(String message, String token, String name, String email, String role) {
        this.message = message;
        this.token = token;
        this.name = name;
        this.email = email;
        this.role = role;
    }

}
