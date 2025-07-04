package com.fooddelivery.onlinefooddelivery.response;

import java.util.HashMap;
import java.util.List;

import com.fooddelivery.onlinefooddelivery.entity.FoodItem;
import com.fooddelivery.onlinefooddelivery.entity.Restaurant;

public class FoodResponseForCustumer<T> {

	private String msg;
	private int responseId;

	private List<Restaurant> restaurants;

//	private FoodResponse foodResponse;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	

//	public FoodResponse getFoodResponse() {
//		return foodResponse;
//	}
//
//	public void setFoodResponse(FoodResponse foodResponse) {
//		this.foodResponse = foodResponse;
//	}

}
