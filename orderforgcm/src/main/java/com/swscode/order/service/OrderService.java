package com.swscode.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.swscode.order.mapper.OrderMapper;
import com.swscode.order.dto.OrderDTO;
import com.swscode.order.dto.OrderDTOFromFrontEnd;
import com.swscode.order.dto.UserDTO;
import com.swscode.order.entity.Order;
import com.swscode.order.repo.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;

	public OrderDTO saveOrderinDb(OrderDTOFromFrontEnd orderDetails) {
		// TODO Auto-generated method stub
		
		//long  orderId  = sequenceGenerator.generateNextOrderId();
		UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
		Order orderToBeSave  = new Order(1,
				orderDetails.getFoodItemsList(),orderDetails.getRestaurant(),userDTO);
		System.out.println("orderToBeSave " + orderToBeSave.getRestaurant().getRestauranrDescription());
		orderRepo.save(orderToBeSave);
		
		return OrderMapper.INSTANCE.orderToOrderDTO(orderToBeSave);
	}

	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		
		return  restTemplate.getForObject("http://USERINFO//user/fetchUser/"+userId, UserDTO.class);
		
		 
		
	}
	

}
