package com.fooddelivery.onlinefooddelivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private double price;

	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	@JsonIgnore
	private Restaurant resaturant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Restaurant getResaturant() {
		return resaturant;
	}

	public void setResturent(Restaurant resaturant) {
		this.resaturant = resaturant;
	}

}
