package com.fooddelivery.onlinefooddelivery.response;

import java.util.List;

import com.fooddelivery.onlinefooddelivery.dto.AddressRequest;
import com.fooddelivery.onlinefooddelivery.entity.Address;
import com.fooddelivery.onlinefooddelivery.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResponse {

	private String msg;
	private String userName;
	private AddressRequest addressRequest;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public AddressRequest getAddressRequest() {
		return addressRequest;
	}
	public void setAddressRequest(AddressRequest addressRequest) {
		this.addressRequest = addressRequest;
	}
	
	

}
