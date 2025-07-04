package com.fooddelivery.onlinefooddelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.onlinefooddelivery.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

}
