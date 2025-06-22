package com.fooddelivery.onlinefooddelivery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.AddressRequest;
import com.fooddelivery.onlinefooddelivery.entity.Address;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.response.AddressResponse;
import com.fooddelivery.onlinefooddelivery.response.SaveAdressResponse;
import com.fooddelivery.onlinefooddelivery.response.fetchUsersByAdressResposnce;
import com.fooddelivery.onlinefooddelivery.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@Autowired
	UserRepo userRepo;

	@PostMapping("/add")
	public ResponseEntity<?> addAddress(@RequestBody AddressRequest addressRequest) {
		Address address = addressService.addAdress(addressRequest);

		AddressResponse addressResponse = new AddressResponse();
		addressResponse.setMsg("Adress saved successfully for user : ");
		addressResponse.setUserName(address.getUser().getName());
		addressResponse.setAddressRequest(addressRequest);

		return ResponseEntity.ok(addressResponse);
	}

	@GetMapping("/get")
	public ResponseEntity<?> fetchUsersByAdress(@RequestParam String name) {
		List<Address> addresses = addressService.fetchUsersByAdress(name);

		List<String> names = new ArrayList<>();
		fetchUsersByAdressResposnce fetchUsersByAdressResposnce = new fetchUsersByAdressResposnce();
		for (Address address : addresses) {
			names.add(address.getUser().getName());
		}

		fetchUsersByAdressResposnce.setMsg("Customers with a same adress");
		fetchUsersByAdressResposnce.setNames(names);

		return ResponseEntity.ok(fetchUsersByAdressResposnce);
	}

}
