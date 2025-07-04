package com.fooddelivery.onlinefooddelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dto.FoodItemRequest;
import com.fooddelivery.onlinefooddelivery.dto.RestaurantRequest;
import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.Restaurant;
import com.fooddelivery.onlinefooddelivery.response.ResponseStructure;
import com.fooddelivery.onlinefooddelivery.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	ResponseStructure<Restaurant> responseStructure;

	@Autowired
	ResponseStructure<FoodItem> responseStructure2;

	@PostMapping("/saveRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(
			@RequestBody RestaurantRequest restaurantRequest) {

		Restaurant restaurant = restaurantService.saveRestaurant(restaurantRequest);

		responseStructure
				.setMsg(restaurant.getName() + " saved in the DB at the Loaction : " + restaurant.getLocation());
		responseStructure.setResponseId(HttpStatus.CREATED.value());
		responseStructure.setResponseData(restaurant);
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	@PostMapping("/updateRestaurantByName")
	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurantByName(
			@RequestBody RestaurantRequest restaurantRequest, @RequestParam String name) {
		responseStructure.setMsg("Restaurant updated succesfully in the DB");
		responseStructure.setResponseId(HttpStatus.OK.value());
		responseStructure.setResponseData(restaurantService.updateRestaurantByName(restaurantRequest, name));

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@PostMapping("/addFoodItemToRestaurant")
	public ResponseEntity<ResponseStructure<FoodItem>> addFoodItemToRestaurant(
			@RequestBody FoodItemRequest foodItemRequest) {

		FoodItem foodItem = restaurantService.addFoodItemToRestaurant(foodItemRequest);

		responseStructure2.setMsg(foodItem.getName() + " is added to  " + foodItem.getResaturant().getName());
		responseStructure2.setResponseId(HttpStatus.OK.value());
		responseStructure2.setResponseData(null);

		return new ResponseEntity<>(responseStructure2, HttpStatus.OK);

	}

}
