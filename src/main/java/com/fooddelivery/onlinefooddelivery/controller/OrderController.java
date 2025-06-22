package com.fooddelivery.onlinefooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dao.AddressRepo;
import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.OrderRequest;
import com.fooddelivery.onlinefooddelivery.entity.Order;
import com.fooddelivery.onlinefooddelivery.response.OrderResponse;
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

		Order order = orderService.placeOrder(orderRequest);

		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setMsg("Order placed");
		orderResponse.setStatus("Delivered");
		orderResponse.setAddress(addressRepo.findById(orderRequest.getAddressId()).get());

		return ResponseEntity.ok(orderResponse);

	}

}
