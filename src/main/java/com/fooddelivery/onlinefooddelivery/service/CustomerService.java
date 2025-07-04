package com.fooddelivery.onlinefooddelivery.service;

import java.util.HashSet;
import java.util.List;

import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.Restaurant;
import com.fooddelivery.onlinefooddelivery.response.RestuarantFoodInfoResponse;

public interface CustomerService {


	List<RestuarantFoodInfoResponse> fetchRestaurantByName(String name);

}
