package com.fooddelivery.onlinefooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dao.AddressRepo;
import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.OrderRequest;
import com.fooddelivery.onlinefooddelivery.dto.OrderResponseDto;
import com.fooddelivery.onlinefooddelivery.entity.Order;
import com.fooddelivery.onlinefooddelivery.response.OrderResponse;
import com.fooddelivery.onlinefooddelivery.response.ResponseStructure;
import com.fooddelivery.onlinefooddelivery.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo addressRepo;

	@PostMapping("/place")
	public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest) {
		return orderService.placeOrder(orderRequest);
	}

	@GetMapping("/placeOrder")
	public ResponseEntity<?> placeOrder(@RequestParam String email, @RequestParam int addressId) {
		OrderResponseDto orderDto = orderService.placeOrder(email, addressId);

		ResponseStructure<OrderResponseDto> response = new ResponseStructure<>();
		response.setMsg("Order placed successfully");
		response.setResponseId(HttpStatus.CREATED.value());
		response.setResponseData(orderDto);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
