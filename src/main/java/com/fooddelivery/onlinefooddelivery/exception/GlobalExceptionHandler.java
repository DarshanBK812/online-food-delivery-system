package com.fooddelivery.onlinefooddelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> userNotFound(NotFoundException userNotFoundException) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userNotFoundException.getMessage());
	}

	@ExceptionHandler(ExistedUser.class)
	public ResponseEntity<String> userExisted(ExistedUser existedUser) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(existedUser.getMessage());
	}

}
