package com.fooddelivery.onlinefooddelivery.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.onlinefooddelivery.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	Optional<List<Address>> findByStreet(String street);

}
