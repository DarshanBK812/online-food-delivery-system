package com.fooddelivery.onlinefooddelivery.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.onlinefooddelivery.dao.AddressRepo;
import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.AddressRequest;
import com.fooddelivery.onlinefooddelivery.entity.Address;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	UserRepo userRepo;

	@Override
	public Address addAdress(AddressRequest addressRequest) {

		User user = userRepo.findById(addressRequest.getUserId())
				.orElseThrow(() -> new NotFoundException("User is not found plz check user id"));
		Address adress = new Address();
		adress.setStreet(addressRequest.getStreet().toLowerCase());
		adress.setCity(addressRequest.getCity().toLowerCase());
		adress.setState(addressRequest.getState().toLowerCase());
		adress.setPincode(addressRequest.getPincode());
		adress.setUser(user);

		return addressRepo.save(adress);

	}

	@Override
	public List<Address> fetchUsersByAdress(String name) {
		Optional<List<Address>> address = addressRepo.findByStreet(name.toLowerCase());

		if (address.isEmpty()) {
			throw new NotFoundException("Adress is not found");
		}

		return address.get();
	}

	// Update the adress by id
	@Override
	public Address updateAdressByAdressID(int adressID, AddressRequest addressRequest) {
		Address address = addressRepo.findById(adressID)
				.orElseThrow(() -> new NotFoundException("Adress is not found Plz check the id"));

		User user = userRepo.findById(addressRequest.getUserId())
				.orElseThrow(() -> new NotFoundException("User is not found Plz check the id"));

		address.setId(adressID);
		address.setStreet(addressRequest.getStreet());
		address.setCity(addressRequest.getCity());
		address.setState(addressRequest.getState());
		address.setPincode(addressRequest.getPincode());
		address.setUser(user);
		addressRepo.save(address);
		return address;

	}
}
