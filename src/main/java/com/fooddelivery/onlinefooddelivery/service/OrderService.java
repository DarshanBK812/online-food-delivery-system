package com.fooddelivery.onlinefooddelivery.service;

import com.fooddelivery.onlinefooddelivery.dto.OrderRequest;
import com.fooddelivery.onlinefooddelivery.entity.Order;

public interface OrderService {

	Order placeOrder(OrderRequest orderRequest);

}
