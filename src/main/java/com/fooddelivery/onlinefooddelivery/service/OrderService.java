package com.fooddelivery.onlinefooddelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.OrderRequest;
import com.fooddelivery.onlinefooddelivery.dto.OrderResponseDto;
import com.fooddelivery.onlinefooddelivery.entity.Order;

public interface OrderService {

	ResponseEntity<?> placeOrder(OrderRequest orderRequest);

	ResponseEntity<?> fetchAllOrdersByAdmine(LoginRequest loginRequest);

	public OrderResponseDto placeOrder(String email, int adressId);

}
