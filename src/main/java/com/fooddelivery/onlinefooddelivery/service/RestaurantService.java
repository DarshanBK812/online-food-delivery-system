package com.fooddelivery.onlinefooddelivery.service;

import com.fooddelivery.onlinefooddelivery.dto.FoodItemRequest;
import com.fooddelivery.onlinefooddelivery.dto.RestaurantRequest;
import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.Restaurant;

public interface RestaurantService {

	public Restaurant saveRestaurant(RestaurantRequest restaurantRequest);

	public Restaurant updateRestaurantByName(RestaurantRequest restaurantRequest, String name);

	public FoodItem addFoodItemToRestaurant(FoodItemRequest foodItemRequest);
}
