package com.fooddelivery.onlinefooddelivery.dto;

import java.util.List;

import com.fooddelivery.onlinefooddelivery.entity.FoodItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class RestaurantRequest {

	private String name;
	private String location;

	@OneToMany(mappedBy = "resaturant", cascade = CascadeType.ALL)
	List<FoodItem> foodItems;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

}
