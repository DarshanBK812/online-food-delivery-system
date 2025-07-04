package com.fooddelivery.onlinefooddelivery.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.onlinefooddelivery.entity.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
	
	Optional<List<FoodItem>> findByNameIgnoreCase(String name);

}
