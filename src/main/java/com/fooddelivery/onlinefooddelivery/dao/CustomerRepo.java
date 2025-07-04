package com.fooddelivery.onlinefooddelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.onlinefooddelivery.entity.User;

public interface CustomerRepo extends JpaRepository<User, Integer> {

}
