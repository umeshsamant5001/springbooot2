package com.swscode.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
	
	private int id;
	private String name;
	private String address;
	private String city;
	private String restauranrDescription;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRestauranrDescription() {
		return restauranrDescription;
	}
	public void setRestauranrDescription(String restauranrDescription) {
		this.restauranrDescription = restauranrDescription;
	}

}
