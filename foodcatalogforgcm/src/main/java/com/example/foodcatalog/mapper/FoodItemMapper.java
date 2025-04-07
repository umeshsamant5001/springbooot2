package com.example.foodcatalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.foodcatalog.dto.FoodItemDTO;
import com.example.foodcatalog.entity.FoodItem;

@Mapper
public interface FoodItemMapper {
	
	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
	FoodItemDTO foodItemToFoodItemDTO(FoodItem foodItem);
	FoodItem foodItemDTOtoFoodItem(FoodItemDTO foodItenDTO);
	

}
