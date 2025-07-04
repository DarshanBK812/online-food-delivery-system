package com.fooddelivery.onlinefooddelivery.service;

import com.fooddelivery.onlinefooddelivery.dto.AddToCartRequest;
import com.fooddelivery.onlinefooddelivery.entity.Cart;

public interface AddCartService {

	public Cart addToCart(AddToCartRequest addToCartRequest);

}
