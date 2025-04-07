package com.swscode.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.swscode.restaurantlisting.dto.RestaurantDTO;
import com.swscode.restaurantlisting.entity.Restaurant;

@Mapper
public interface RestaurantMapper {
	
	
	
	// two methods : for mapping Restaurant to RestaurantDTO and other for RestaurantDTO to Restaurant
	
	//Instance of RestaurantMappe interface to only use in RestaurantService
	RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
	
	
    // Abstarct method for mapping RestaurantDTO to Restaurant
    Restaurant mapRestaurantDToRestaurant(RestaurantDTO restaurantDTO);
    
 // Abstarct method for mapping   Restaurant to RestaurantDTO
    
    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);
    
}
