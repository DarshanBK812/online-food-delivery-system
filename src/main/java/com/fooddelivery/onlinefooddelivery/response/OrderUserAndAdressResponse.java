package com.fooddelivery.onlinefooddelivery.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUserAndAdressResponse {

	private String userName;
	private String userStreet;
	private String userPincode;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserStreet() {
		return userStreet;
	}
	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}
	public String getUserPincode() {
		return userPincode;
	}
	public void setUserPincode(String userPincode) {
		this.userPincode = userPincode;
	}
	
	


}
