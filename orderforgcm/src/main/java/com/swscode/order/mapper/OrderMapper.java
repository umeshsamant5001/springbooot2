package com.swscode.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.swscode.order.dto.OrderDTO;
import com.swscode.order.entity.Order;

@Mapper
public interface OrderMapper {
	
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	OrderDTO orderToOrderDTO(Order order);
	Order orderDTOToOrder(OrderDTO orderDTO);
	

}
