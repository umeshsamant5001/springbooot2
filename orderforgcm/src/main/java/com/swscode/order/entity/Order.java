package com.swscode.order.entity;

import java.util.List;


import org.springframework.data.mongodb.core.mapping.Document;

import com.swscode.order.dto.FoodItemDTO;
import com.swscode.order.dto.Restaurant;
import com.swscode.order.dto.UserDTO;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "order")
public class Order {
	
	
	private long orderId;
	private List<FoodItemDTO> foodItemsList;
	private Restaurant restaurant;
	private UserDTO userDTO;
	
	public Order(long orderId,List<FoodItemDTO> foodItemsList,Restaurant restaurant,UserDTO userDTO) {
		this.orderId = orderId;
		this.foodItemsList = foodItemsList;
		this.restaurant = restaurant;
		this.userDTO = userDTO;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public List<FoodItemDTO> getFoodItemsList() {
		return foodItemsList;
	}

	public void setFoodItemsList(List<FoodItemDTO> foodItemsList) {
		this.foodItemsList = foodItemsList;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
