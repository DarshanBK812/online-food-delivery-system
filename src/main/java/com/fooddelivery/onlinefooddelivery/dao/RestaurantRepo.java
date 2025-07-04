package com.fooddelivery.onlinefooddelivery.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.onlinefooddelivery.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

	Optional<Restaurant> findByLocation(String location);

	Optional<Restaurant> findByName(String name);

}
