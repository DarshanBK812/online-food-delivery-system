package com.fooddelivery.onlinefooddelivery.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {

	private String msg;
	private int responseId;
	private T responseData;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public T getResponseData() {
		return responseData;
	}

	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}

}
