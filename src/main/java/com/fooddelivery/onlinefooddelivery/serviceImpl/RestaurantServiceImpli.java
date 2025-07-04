package com.fooddelivery.onlinefooddelivery.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.onlinefooddelivery.dao.FoodItemRepo;
import com.fooddelivery.onlinefooddelivery.dao.RestaurantRepo;
import com.fooddelivery.onlinefooddelivery.dto.FoodItemRequest;
import com.fooddelivery.onlinefooddelivery.dto.RestaurantRequest;
import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.Restaurant;
import com.fooddelivery.onlinefooddelivery.exception.ExistedUser;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.service.RestaurantService;

@Service
public class RestaurantServiceImpli implements RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	@Autowired
	FoodItemRepo foodItemRepo;

	@Override
	public Restaurant saveRestaurant(RestaurantRequest restaurantRequest) {

		Optional<Restaurant> optional = restaurantRepo.findByLocation(restaurantRequest.getLocation().toLowerCase());

		if (optional.isPresent()) {
			throw new ExistedUser("Restaurant already existed in this location");
		}
		Restaurant restaurant = new Restaurant();
		restaurant.setName(restaurantRequest.getName().toLowerCase());
		restaurant.setLocation(restaurantRequest.getLocation().toLowerCase());

		return restaurantRepo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurantByName(RestaurantRequest restaurantRequest, String name) {
		Optional<Restaurant> optional = restaurantRepo.findByName(name);
		if (optional.isEmpty()) {
			throw new NotFoundException("Restaurant not found ");
		}

		Restaurant newNestaurant = optional.get();

		Restaurant restaurant = new Restaurant();

		restaurant.setId(newNestaurant.getId());
		restaurant.setName(restaurantRequest.getName());
		restaurant.setLocation(restaurantRequest.getLocation());
		restaurant.setFoodItems(restaurantRequest.getFoodItems());

		return restaurantRepo.save(restaurant);
	}

	@Override
	public FoodItem addFoodItemToRestaurant(FoodItemRequest foodItemRequest) {

		Optional<Restaurant> restaurant = restaurantRepo.findById(foodItemRequest.getRestaurantId());
		if (restaurant.isEmpty()) {
			throw new NotFoundException("Restuarant not found with a id");
		}

		FoodItem foodItem = new FoodItem();
		foodItem.setName(foodItemRequest.getName());
		foodItem.setPrice(foodItemRequest.getPrice());
		foodItem.setResturent(restaurant.get());

		return foodItemRepo.save(foodItem);
	}

}
