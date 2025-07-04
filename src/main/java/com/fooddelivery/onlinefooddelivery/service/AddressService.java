package com.fooddelivery.onlinefooddelivery.service;

import java.util.List;

import com.fooddelivery.onlinefooddelivery.dto.AddressRequest;
import com.fooddelivery.onlinefooddelivery.entity.Address;

public interface AddressService {

	Address addAdress(AddressRequest adressRequest);

	List<Address> fetchUsersByAdress(String name);

	Address updateAdressByAdressID(int adressID, AddressRequest addressRequest);

}
