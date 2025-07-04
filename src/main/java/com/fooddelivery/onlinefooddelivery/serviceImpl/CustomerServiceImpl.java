package com.fooddelivery.onlinefooddelivery.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.onlinefooddelivery.dao.FoodItemRepo;
import com.fooddelivery.onlinefooddelivery.dao.RestaurantRepo;
import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.Restaurant;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.response.RestuarantFoodInfoResponse;
import com.fooddelivery.onlinefooddelivery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	FoodItemRepo foodItemRepo;

	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public List<RestuarantFoodInfoResponse> fetchRestaurantByName(String name) {

		List<FoodItem> foodItems = foodItemRepo.findByNameIgnoreCase(name)
				.orElseThrow(() -> new NotFoundException(name + " is Not available"));

		List<RestuarantFoodInfoResponse> foodInfoResponses = new ArrayList<RestuarantFoodInfoResponse>();

		for (FoodItem foodItem : foodItems) {
			RestuarantFoodInfoResponse foodInfoResponse = new RestuarantFoodInfoResponse();
			foodInfoResponse.setRestuarantName(foodItem.getResaturant().getName());
			foodInfoResponse.setFoodName(foodItem.getName());
			foodInfoResponse.setFoodCost(foodItem.getPrice());
			foodInfoResponses.add(foodInfoResponse);
		}
		return foodInfoResponses;
	}

}
