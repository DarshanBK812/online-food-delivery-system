package com.fooddelivery.onlinefooddelivery.response;

import java.util.List;

import com.fooddelivery.onlinefooddelivery.entity.Address;
import com.fooddelivery.onlinefooddelivery.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

	private String msg;
//	private int orderId;
	private String status;

	public OrderResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
