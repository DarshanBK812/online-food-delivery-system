package com.fooddelivery.onlinefooddelivery.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fooddelivery.onlinefooddelivery.dao.AddressRepo;
import com.fooddelivery.onlinefooddelivery.dao.CartRepo;
import com.fooddelivery.onlinefooddelivery.dao.OrderRepo;
import com.fooddelivery.onlinefooddelivery.dao.UserRepo;
import com.fooddelivery.onlinefooddelivery.dto.LoginRequest;
import com.fooddelivery.onlinefooddelivery.dto.OrderItemDto;
import com.fooddelivery.onlinefooddelivery.dto.OrderRequest;
import com.fooddelivery.onlinefooddelivery.dto.OrderResponseDto;
import com.fooddelivery.onlinefooddelivery.entity.Address;
import com.fooddelivery.onlinefooddelivery.entity.Cart;
import com.fooddelivery.onlinefooddelivery.entity.Order;
import com.fooddelivery.onlinefooddelivery.entity.OrderItem;
import com.fooddelivery.onlinefooddelivery.entity.User;
import com.fooddelivery.onlinefooddelivery.exception.NotFoundException;
import com.fooddelivery.onlinefooddelivery.response.OrderResponse;
import com.fooddelivery.onlinefooddelivery.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	AddressRepo adressRepo;

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	CartRepo cartRepo;

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
	public ResponseEntity<?> placeOrder(OrderRequest orderRequest) {
		User customer = userRepo.findById(orderRequest.getUserId())
				.orElseThrow(() -> new NotFoundException("User is not found please check the id"));
		Address address = adressRepo.findById(orderRequest.getAddressId())
				.orElseThrow(() -> new NotFoundException("Adress is not found please check the adress id"));

		Order order = new Order();
		order.setUser(customer);
		order.setAddress(address);
		order.setOrderStatus("deliverd");
		order.setOrderTime(LocalDateTime.now());

		orderRepo.save(order);

		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setMsg("Congratulations ! " + order.getUser().getName() + " Order is  placed to adress : "
				+ order.getAddress().getStreet());
		orderResponse.setStatus("Delivered");

		return ResponseEntity.ok(orderResponse);
	}

	@Override
	public ResponseEntity<?> fetchAllOrdersByAdmine(LoginRequest loginRequest) {

		Optional<User> admine = userRepo.findByEmail(loginRequest.getEmail());
		if (admine.isEmpty() || !admine.get().getPassword().equals(loginRequest.getPassword())
				|| !admine.get().getRole().equals("admin")) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Restricted limited access only !");
		}

		List<Order> orders = orderRepo.findAll();

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(orders);
	}

	@Override
	public OrderResponseDto placeOrder(String email, int addressId) {
		// Step 1: Fetch user
		Optional<User> optionalUser = userRepo.findByEmail(email);
		if (optionalUser.isEmpty())
			throw new NotFoundException("User not found with email: " + email);
		User user = optionalUser.get();

		// Step 2: Fetch address
		Optional<Address> optionalAddress = adressRepo.findById(addressId);
		if (optionalAddress.isEmpty())
			throw new RuntimeException("Address not found with ID: " + addressId);
		Address address = optionalAddress.get();

		// Step 3: Fetch user's cart items
		List<Cart> carts = cartRepo.findByCustomerId(user.getId());
		if (carts.isEmpty())
			throw new RuntimeException("Cart is empty. Add items before placing order.");

		// Step 4: Create Order entity
		Order order = new Order();
		order.setUser(user);
		order.setAddress(address);
		order.setOrderTime(LocalDateTime.now());
		order.setOrderStatus("PLACED");

		List<OrderItem> orderItems = new ArrayList<>();
		for (Cart cart : carts) {
			OrderItem orderItem = new OrderItem();
			orderItem.setFoodItem(cart.getFoodItem());
			orderItem.setQuantity(cart.getQuantity());
			orderItem.setPrice(cart.getFoodItem().getPrice() * cart.getQuantity());
			orderItem.setOrder(order);
			orderItems.add(orderItem);
		}

		order.setItems(orderItems);

		// Step 5: Save order and clear cart
		Order savedOrder = orderRepo.save(order);
		cartRepo.deleteAll(carts);

		// Step 6: Convert to DTO
		OrderResponseDto dto = new OrderResponseDto();
		dto.setOrderId(savedOrder.getId());
		dto.setStatus(savedOrder.getOrderStatus());
		dto.setOrderTime(savedOrder.getOrderTime());
		dto.setCustomerName(user.getName());
		dto.setDeliveryAddress(address.getStreet());

		List<OrderItemDto> itemDtos = new ArrayList<>();
		for (OrderItem item : savedOrder.getItems()) {
			OrderItemDto itemDto = new OrderItemDto();
			itemDto.setFoodName(item.getFoodItem().getName());
			itemDto.setQuantity(item.getQuantity());
			itemDto.setPrice(item.getPrice());
			itemDtos.add(itemDto);
		}

		dto.setItems(itemDtos);

		return dto;
	}

}
