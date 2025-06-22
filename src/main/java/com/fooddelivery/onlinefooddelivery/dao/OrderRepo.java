package com.fooddelivery.onlinefooddelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.onlinefooddelivery.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
