package com.swscode.order.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swscode.order.dto.OrderDTO;
import com.swscode.order.dto.OrderDTOFromFrontEnd;
import com.swscode.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFrontEnd orderDetails) {
		
		OrderDTO orderSavedInDb = orderService.saveOrderinDb(orderDetails);
		return new ResponseEntity<OrderDTO>(orderSavedInDb, null, HttpStatus.SC_CREATED);
		
	}

}
