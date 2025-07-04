package com.fooddelivery.onlinefooddelivery.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.onlinefooddelivery.dao.CartRepo;
import com.fooddelivery.onlinefooddelivery.dao.FoodItemRepo;
import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.AddToCartRequest;
import com.fooddelivery.onlinefooddelivery.entity.Cart;
import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.service.AddCartService;

@Service
public class AddCartServiceImpl implements AddCartService {

	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	UserRepo userRepo;

	@Autowired
	FoodItemRepo foodItemRepo;

	@Override
	public Cart addToCart(AddToCartRequest addToCartRequest) {

		User customer = userRepo.findById(addToCartRequest.getCustomerId())
				.orElseThrow(() -> new NotFoundException("Customer not found"));
		FoodItem foodItem = foodItemRepo.findById(addToCartRequest.getFoodItemId())
				.orElseThrow(() -> new NotFoundException("Food item not found"));

		Cart cart = new Cart();
		cart.setQuantity(addToCartRequest.getQuantity());
		cart.setCustomer(customer);
		cart.setFoodItem(foodItem);

		return cartRepo.save(cart);
	}

}
