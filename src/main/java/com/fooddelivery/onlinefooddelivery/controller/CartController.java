package com.fooddelivery.onlinefooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dto.AddToCartRequest;
import com.fooddelivery.onlinefooddelivery.entity.Cart;
import com.fooddelivery.onlinefooddelivery.response.ResponseStructure;
import com.fooddelivery.onlinefooddelivery.service.AddCartService;
import com.fooddelivery.onlinefooddelivery.service.CustomerService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	AddCartService addCartService;

	@PostMapping("/addToCart")
	public ResponseEntity<ResponseStructure<Cart>> addToCart(@RequestBody AddToCartRequest request) {
		
		Cart cart = addCartService.addToCart(request);
		
		ResponseStructure<Cart> response = new ResponseStructure<>();
		response.setMsg("Item added to cart");
		response.setResponseId(HttpStatus.CREATED.value());
		response.setResponseData(cart);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
