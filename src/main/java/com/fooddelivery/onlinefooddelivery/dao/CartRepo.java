package com.fooddelivery.onlinefooddelivery.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.onlinefooddelivery.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {
	
	List<Cart> findByCustomerId(int customerId);

}
