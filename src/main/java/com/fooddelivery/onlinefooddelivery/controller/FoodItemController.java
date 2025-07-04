//package com.fooddelivery.onlinefooddelivery.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fooddelivery.onlinefooddelivery.dto.FoodItemRequest;
//import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
//import com.fooddelivery.onlinefooddelivery.response.ResponseStructure;
//import com.fooddelivery.onlinefooddelivery.service.RestaurantService;
//
//@RestController
//@RequestMapping("foodItem")
//public class FoodItemController {
//	
//	@Autowired
//	RestaurantService restaurantService;
//	
//	ResponseStructure<Fo>
//	
//public ResponseEntity<ResponseStructure<FoodItem>> addFoodItemToRestaurant(FoodItemRequest foodItemRequest) {
//		
//		FoodItem foodItem = restaurantService.addFoodItemToRestaurant(foodItemRequest);
//		
//		responseStructure.setMsg(foodItem.getName() + " is added to  " + foodItem.getResaturant().getName());
//		responseStructure.setResponseId(HttpStatus.OK.value());
//		responseStructure.setResponseData(foodItem);
//		
//		return 
//				
//		
//	}
//
//}
