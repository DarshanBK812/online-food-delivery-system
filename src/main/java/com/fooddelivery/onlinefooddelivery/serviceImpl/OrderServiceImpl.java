package com.fooddelivery.onlinefooddelivery.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fooddelivery.onlinefooddelivery.dao.AddressRepo;
import com.fooddelivery.onlinefooddelivery.dao.OrderRepo;
import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.OrderRequest;
import com.fooddelivery.onlinefooddelivery.entity.Address;
import com.fooddelivery.onlinefooddelivery.entity.Order;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo adressRepo;

	@Autowired
	OrderRepo orderRepo;

//	@Override
//	public Order placeOrder(OrderRequest orderRequest) {
//
//		User user = userRepo.findById(orderRequest.getUserId())
//				.orElseThrow(() -> new NotFoundException("User is not found please check the id"));
//		Address adress = adressRepo.findById(orderRequest.getAdressId())
//				.orElseThrow(() -> new NotFoundException("Adress is not found plz check adress id"));
//
//		Order order = new Order();
//		order.setUser(user);
//		order.setAddress(adress);
//		order.setOrderStatus("Placed");
//		order.setOrderTime(LocalDateTime.now());
//
//		return orderRepo.save(order);
//	}

	@Override
	public Order placeOrder(OrderRequest orderRequest) {
		User customer = userRepo.findById(orderRequest.getUserId())
				.orElseThrow(() -> new NotFoundException("User is not found please check the id"));
		Address address = adressRepo.findById(orderRequest.getAddressId())
				.orElseThrow(() -> new NotFoundException("Adress is not found please check the adress id"));

		Order order = new Order();
		order.setUser(customer);
		order.setAddress(address);
		order.setOrderStatus("deliverd");
		order.setOrderTime(LocalDateTime.now());

		return order;
	}

}
